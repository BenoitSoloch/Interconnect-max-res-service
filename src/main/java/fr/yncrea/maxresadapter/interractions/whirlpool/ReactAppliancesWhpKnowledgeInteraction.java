package fr.yncrea.maxresadapter.interractions.whirlpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.GraphPattern;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.ReactKnowledgeInteraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ReactAppliancesWhpKnowledgeInteraction extends ReactKnowledgeInteraction {

    private final Logger log = LogManager.getLogger();
    protected ReactAppliancesWhpKnowledgeInteraction(@Value("${graphpattern.whirlpoolpowerprofile}") String argumentPattern,
                                                     @Value("${graphpattern.whirlpoolresult}") String resultPattern) {
        super(argumentPattern, resultPattern);
    }

    @Override
    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> request) {
        log.info("-- React: " + request);

        return Optional.empty();
    }
}
