package fr.yncrea.maxresadapter.controllers;

import fr.yncrea.maxresadapter.graphpattern.BindingSetMapper;
import fr.yncrea.maxresadapter.interractions.inetum.PostDeviceDeletionInteraction;
import fr.yncrea.maxresadapter.interractions.inetum.PostDeviceRegistrationInteraction;
import fr.yncrea.maxresadapter.interractions.whirlpool.AskWhpKnowledgeInteraction;
import fr.yncrea.maxresadapter.interractions.whirlpool.AskRegistrationWhpInteraction;
import fr.yncrea.maxresadapter.models.ApplianceModel;
import fr.yncrea.maxresadapter.models.inetum.DeletionInetumModel;
import fr.yncrea.maxresadapter.models.inetum.RegistrationInetumModel;
import fr.yncrea.maxresadapter.models.whirlpool.RegistrationWhirlpoolModel;
import fr.yncrea.maxresadapter.models.whirlpool.AskWhirlpoolModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openapitools.client.model.AskResult;
import org.openapitools.client.model.PostResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import world.inetum.dr.knowledge_engine.adapter.interactions.ProactiveClient;

//import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class Controller {
    private final ProactiveClient knowledgeEngineClient;
    private final PostDeviceRegistrationInteraction inetumRegistrationInteraction;
    private final PostDeviceDeletionInteraction inetumDeletionInteraction;
    private final AskWhpKnowledgeInteraction whpKI;
    private final AskRegistrationWhpInteraction whpKIregister;
    private final BindingSetMapper bindingSetMapper;
    private String token;
    private final Logger log = LogManager.getLogger();

    public Controller(ProactiveClient knowledgeEngineClient,
                      PostDeviceRegistrationInteraction inetumRegistrationInteraction,
                      PostDeviceDeletionInteraction inetumDeletionInteraction,
                      AskWhpKnowledgeInteraction whpKI,
                      AskRegistrationWhpInteraction whpKIregister,
                      BindingSetMapper bindingSetMapper) {
        this.knowledgeEngineClient = knowledgeEngineClient;
        this.inetumRegistrationInteraction = inetumRegistrationInteraction;
        this.inetumDeletionInteraction = inetumDeletionInteraction;
        this.whpKI = whpKI;
        this.whpKIregister = whpKIregister;
        this.bindingSetMapper = bindingSetMapper;
    }

    @GetMapping(path = "/whp-ask")
    public ResponseEntity<List<ApplianceModel>> getDevices(String token) {
        // TODO
        // - Get PDL value
        // - Get Appliances datas
        // - Create Appliances registered list
        // - Check if appliances are in the list for registration
        // - Send Device registration if needed
        // - Send Appliances registration to Whirlpool for each device
        // - Create PDL/Encrypted-PDL table
        // - Check PDL table before registration

        log.info("Request received with token: " + token);
        this.token = token;

//        AskWhirlpoolModel model = new AskWhirlpoolModel(
//                "https://www.example.org/appliances",
//                "FR-Kpq1z",
//                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50SWQiOjIyNjU3NiwiUm9sZU5hbWUiOiJTVEFOREFSRF9VU0VSIiwiY29tcGFueUlkIjowLCJVc2VyTmFtZSI6IkJlbm_DrnRTb2xvY2giLCJ1c2VyX25hbWUiOiJCRU5PSVQuU09MT0NIQFlOQ1JFQS5GUiIsInNjb3BlIjpbInRydXN0IiwicmVhZCIsIndyaXRlIl0sImV4cCI6MTY4NDI0ODEyOCwiYXV0aG9yaXRpZXMiOlsiU1RBTkRBUkRfVVNFUiJdLCJqdGkiOiJmNGVjZGRmNC1iZjVjLTRhYzUtYTk0Yy1jZGNkMzc2OTc2YmMiLCJjbGllbnRfaWQiOiJzcnZzeXN3Y2VtZWEiLCJTQUlEIjpbIldQUjRXSzRLR0wzMzQiXX0.qje58mD0AjF8BWfkW7KISmiD9UWuIuohzBrFtoWb3rU"
//        );
//
//        List<AskWhirlpoolModel> list = new ArrayList<>();
//        list.add(model);
//
//        log.info("Model: " + model);
//
//        this.knowledgeEngineClient.ask(this.whpKI, bindingSetMapper.mapActuationsToBindingAskWhirlpool(list));

        ApplianceModel appliance1 = new ApplianceModel(
                "WPR4WK4KGL334",
                "Lave linge 460",
                true,
                "FabricCare",
                "Hotpoint",
                true,
                ""
        );
        List<ApplianceModel> appliances = new ArrayList<>();
        appliances.add(appliance1);

        return ResponseEntity.ok(appliances);
    }

    @PostMapping(path = "/whp-registration")
    public ResponseEntity<Object> postRegistration(
            @RequestBody List<ApplianceModel> appliances
    ) {
        // TODO
        // - Create PDL/Encrypted-PDL table

        log.info("Registration received");
        List<RegistrationInetumModel> registrationList = new ArrayList<>();
        List<DeletionInetumModel> deletionList = new ArrayList<>();
        List<RegistrationWhirlpoolModel> whpDeviceRegistration = new ArrayList<>();

        for(ApplianceModel appliance: appliances) {
            log.info("- Appliance: " + appliance);
            if(appliance.registered()){
                RegistrationInetumModel registrationModel = new RegistrationInetumModel(
                    "http://interconnectproject.eu/pilots/france/building/"+appliance.pdl(),
                    "http://interconnectproject.eu/pilots/france/buildingSpace/"+appliance.pdl()+"/Room1",
                    "http://interconnectproject.eu/pilots/france/device/"+appliance.pdl()+"/" + appliance.deviceAddress(),
                    appliance.type(),
                    appliance.name(),
                    appliance.brand()
                );
                registrationList.add(registrationModel);
                log.info("- Registration added: " + registrationModel);
            }
            else{
                DeletionInetumModel deletionModel = new DeletionInetumModel(
                    "http://interconnectproject.eu/pilots/france/building/"+appliance.pdl(),
                    "http://interconnectproject.eu/pilots/france/buildingSpace/"+appliance.pdl()+"/Room1",
                    "http://interconnectproject.eu/pilots/france/device/"+appliance.pdl()+"/" + appliance.deviceAddress()
                );
                deletionList.add(deletionModel);
                log.info("- Deletion added: " + deletionModel);
            }

            RegistrationWhirlpoolModel registrationWhpModel = new RegistrationWhirlpoolModel(
                    appliance.deviceAddress(),
                    "https://www.example.org/register",
                    "FR-Kpq1z",
                    this.token,
                    appliance.registered()
            );

            whpDeviceRegistration.add(registrationWhpModel);
        }

//        if(!registrationList.isEmpty()){
//            PostResult postResult = this.knowledgeEngineClient.post(inetumRegistrationInteraction, bindingSetMapper.mapActuationsToBindingRegistrationInetum(registrationList));
//            log.info("Post result from Registration: " + postResult);
//        }
//
//        if(!deletionList.isEmpty()){
//            PostResult postResult =this.knowledgeEngineClient.post(inetumDeletionInteraction, bindingSetMapper.mapActuationsToBindingDeletionInetum(deletionList));
//            log.info("Post result from Deletion: " + postResult);
//        }

        log.info("- Send registration to Whirpool");
        log.info("- Device Registration: " + bindingSetMapper.mapActuationsToBindingRegisterWhirlpool(whpDeviceRegistration));
        AskResult result = this.knowledgeEngineClient.ask(this.whpKIregister, bindingSetMapper.mapActuationsToBindingRegisterWhirlpool(whpDeviceRegistration));
        log.info("Result: " + result.getBindingSet());

        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/whp-get-devices")
    public ResponseEntity<?> getTest(@RequestParam String token) {
        log.info("Test ASK request");
        this.token = token;

        AskWhirlpoolModel model = new AskWhirlpoolModel(
                "https://www.example.org/appliances",
                "FR-Kpq1z",
                token
        );

        List<AskWhirlpoolModel> list = new ArrayList<>();
        list.add(model);

        AskResult result = this.knowledgeEngineClient.ask(this.whpKI, bindingSetMapper.mapActuationsToBindingAskWhirlpool(list));
        log.info("Result: " + result.getBindingSet());

        return ResponseEntity.ok(result.getBindingSet());
    }
}
