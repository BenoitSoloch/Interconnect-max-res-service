package fr.yncrea.maxresadapter.interractions.whirlpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.AskAnswerKnowledgeInteraction;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.AskKnowledgeInteraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AskWhpKnowledgeInteraction extends AskKnowledgeInteraction {
    private final Logger log = LogManager.getLogger();
    public AskWhpKnowledgeInteraction(@Value("${graphpattern.whirlpoolappliances}") String resultPattern) {
        super(resultPattern);

        log.info("Result pattern: " + getResultPattern());
    }
}
