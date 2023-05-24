package fr.yncrea.maxresadapter.interractions;

import fr.yncrea.maxresadapter.graphpattern.BindingSetHandler;
import fr.yncrea.maxresadapter.graphpattern.BindingSetMapper;
import fr.yncrea.maxresadapter.models.ResultModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.ReactKnowledgeInteraction;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class PowerReachedKnowledgeInteraction extends ReactKnowledgeInteraction {

    private final Logger log = LogManager.getLogger();
    private final BindingSetHandler bindingSetHandler;
    private final BindingSetMapper bindingSetMapper;

    public PowerReachedKnowledgeInteraction(@Value("${graphpattern.powerreached}") String argument,
                                            @Value("${graphpattern.result}") String result,
                                            BindingSetHandler bindingSetHandler,
                                            BindingSetMapper bindingSetMapper) {
        super(argument, result);
        this.bindingSetHandler = bindingSetHandler;
        this.bindingSetMapper = bindingSetMapper;
    }

    @Override
    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> bindingSet) {
        log.info("-- Power Reached interaction received");

        boolean validity = this.bindingSetHandler.checkGraphPatternValidity(bindingSet, argumentPattern);
        List<ResultModel> resultModels = new ArrayList<>();

        resultModels.add(new ResultModel(
                "ENEDIS_OVER_LOAD_ALERT",
                "http://interconnectproject.eu/pilots/france/Response/"+ UUID.randomUUID(),
                "[{status=ERROR, message=Graph Pattern not valid.}]",
                "FAILURE",
                LocalDateTime.now().toString()
        ));

        List<Map<String, String>>  results = bindingSetMapper.mapActuationsToBindingSetsResult(resultModels);
        Optional<List<Map<String, String>>> opt = Optional.ofNullable(results);
        log.info("Results: " + results);
        log.info("Compute done");
        return opt;
    }
}
