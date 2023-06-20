package fr.yncrea.maxresadapter.graphpattern;

import fr.yncrea.maxresadapter.models.ResultModel;
import fr.yncrea.maxresadapter.models.StopDeviceModel;
import fr.yncrea.maxresadapter.models.inetum.DeletionInetumModel;
import fr.yncrea.maxresadapter.models.inetum.RegistrationInetumModel;
import fr.yncrea.maxresadapter.models.whirlpool.AskWhirlpoolModel;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.engine.binding.Binding;
import org.apache.jena.sparql.engine.binding.BindingBuilder;
import org.apache.jena.sparql.engine.binding.BindingFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BindingSetMapper {

    private final Logger log = LogManager.getLogger();

    public List<Binding> mapBindingSetToBindingList(List<Map<String, String>> bindingSet) {
        return bindingSet.stream()
                .map(this::mapBindingMapToBinding)
                .collect(Collectors.toList());
    }

    private Binding mapBindingMapToBinding(Map<String, String> binding) {
        return binding.entrySet().stream()
                .map(be -> BindingFactory.binding(
                        Var.alloc(be.getKey()),
                        NodeFactory.createURI(be.getValue())
                )).collect(
                        BindingBuilder::create,
                        BindingBuilder::addAll,
                        (bb1, bb2) -> bb1.addAll(bb2.build())
                ).build();
    }

    public List<Map<String, String>> mapActuationsToBindingSets(List<StopDeviceModel> stopDevices) {
        log.debug("Mapping {} to bindingsets", stopDevices);
        return stopDevices.stream()
                .map(this::mapActuationToBinding)
                .collect(Collectors.toList());
    }
    public List<Map<String, String>> mapActuationsToBindingAskWhirlpool(List<AskWhirlpoolModel> stopDevices) {
        log.debug("Mapping {} to bindingsets", stopDevices);
        return stopDevices.stream()
                .map(this::mapActuationToBindingAskWhirlpool)
                .collect(Collectors.toList());
    }

    public List<Map<String, String>> mapActuationsToBindingRegistrationInetum(List<RegistrationInetumModel> registrationDevices) {
        return registrationDevices.stream()
                .map(this::mapActuationToBindingInetumRegistration)
                .collect(Collectors.toList());
    }

    public List<Map<String, String>> mapActuationsToBindingDeletionInetum(List<DeletionInetumModel> deletionDevices) {
        return deletionDevices.stream()
                .map(this::mapActuationToBindingInetumDeletion)
                .collect(Collectors.toList());
    }

    public List<Map<String, String>> mapActuationsToBindingSetsResult(List<ResultModel> resultModels) {
        log.debug("Mapping {} to bindingsets", resultModels);
        return resultModels.stream()
                .map(this::mapActuationToBindingResult)
                .collect(Collectors.toList());
    }

    private Map<String, String> mapActuationToBinding(StopDeviceModel stopAdvice) {
        Map<String, String> map = new HashMap<>();
        map.put("ls", sarefValue(stopAdvice.ls()));
        map.put("pdl", sarefValue(stopAdvice.pdl()));
        map.put("dinf", sarefValue(stopAdvice.dinf()));
        map.put("deviceId", sarefValue(stopAdvice.deviceId()));
        map.put("deviceName", doubleQuote(stopAdvice.deviceName(), "string"));
        map.put("state", doubleQuote(stopAdvice.state(), "string"));
        map.put("emergency", doubleQuote(String.valueOf(stopAdvice.emergency()), "boolean"));
        return map;
    }

    private Map<String, String> mapActuationToBindingResult(ResultModel stopAdvice) {
        Map<String, String> map = new HashMap<>();
        map.put("requestType", doubleQuote(stopAdvice.type(), "string"));
        map.put("response", sarefValue(stopAdvice.response()));
        map.put("responseDetails", doubleQuote(stopAdvice.details(), "string"));
        map.put("responseStatus", doubleQuote(stopAdvice.status(), "string"));
        map.put("timestamp", doubleQuote(stopAdvice.timestamp(), "string"));
        return map;
    }

    private Map<String, String> mapActuationToBindingAskWhirlpool(AskWhirlpoolModel askModel) {
        Map<String, String> map = new HashMap<>();
        map.put("appliances", sarefValue(askModel.appliances()));
        map.put("playerid", doubleQuoteXMLSchema(askModel.playerid(), "string"));
        map.put("token", doubleQuoteXMLSchema(askModel.token(), "string"));
        return map;
    }

    private Map<String, String> mapActuationToBindingInetumRegistration(RegistrationInetumModel registrationModel) {
        Map<String, String> map = new HashMap<>();
        map.put("building", sarefValue(registrationModel.building()));
        map.put("buildingSpace", sarefValue(registrationModel.buildingSpace()));
        map.put("device", sarefValue(registrationModel.device()));
        map.put("classification", doubleQuoteXMLSchema(registrationModel.classification(), "string"));
        map.put("description", doubleQuoteXMLSchema(registrationModel.description(), "string"));
        map.put("serviceProviderEMSOwner", doubleQuoteXMLSchema(registrationModel.serviceProviderEMSOwner(), "string"));
        return map;
    }

    private Map<String, String> mapActuationToBindingInetumDeletion(DeletionInetumModel deletionModel) {
        Map<String, String> map = new HashMap<>();
        map.put("building", sarefValue(deletionModel.building()));
        map.put("buildingSpace", sarefValue(deletionModel.buildingSpace()));
        map.put("device", sarefValue(deletionModel.device()));
        return map;
    }

    /*
        private String doubleQuote(String string, String type) {
            return String.format("\"%s\"^^xsd:%s", string, type);
        }

     */
    private String doubleQuote(String string, String type) {
        return "\"" + string + "\"^^xsd:" + type;
    }
    private String doubleQuoteXMLSchema(String string, String type) {
        return "\"" + string + "\"^^<http://www.w3.org/2001/XMLSchema#" + type + ">";
    }
    private String sarefValue(String string) {
        return String.format("<%s>", string);
    }
}
