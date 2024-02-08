package fr.yncrea.maxresadapter.interractions.keo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.ReactKnowledgeInteraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ReactUnknownData extends ReactKnowledgeInteraction {

    private final Logger log = LogManager.getLogger();
    protected ReactUnknownData(@Value("${graphpattern.keo.unknowddata}") String argumentPattern,
                                  @Value("${graphpattern.keo.result}") String result) {
        super(argumentPattern, result);
    }

    @Override
    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> request) {
        log.info("-- React: " + request);

        return Optional.empty();
    }
}
