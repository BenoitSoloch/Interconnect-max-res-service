package fr.yncrea.maxresadapter.interractions.trialog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.ReactKnowledgeInteraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReactStatusNotificationInteraction extends ReactKnowledgeInteraction {

    private final Logger log = LogManager.getLogger();
    protected ReactStatusNotificationInteraction(@Value("${graphpattern.statusnotification}") String argumentPattern,
                                                 @Value("${graphpattern.result}") String result) {
        super(argumentPattern);
    }

    @Override
    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> request) {
        log.info("-- React: " + request);

        return Optional.empty();
    }
}
