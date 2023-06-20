package fr.yncrea.maxresadapter.interractions.whirlpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.AnswerKnowledgeInteraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AnswerWhpKnowledgeInteraction extends AnswerKnowledgeInteraction {

    private final Logger log = LogManager.getLogger();
    protected AnswerWhpKnowledgeInteraction(@Value("${graphpattern.test}") String resultPattern) {
        super(resultPattern);
    }

    @Override
    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> request) {
        log.info("[ ANSWER ] Results received: " + request);
        return Optional.empty();
    }
}
