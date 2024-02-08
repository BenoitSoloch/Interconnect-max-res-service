package fr.yncrea.maxresadapter.interractions.whirlpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.AskKnowledgeInteraction;

import java.util.List;

@Component
public class AskWhpKnowledgeInteraction extends AskKnowledgeInteraction {
    private final Logger log = LogManager.getLogger();
    public AskWhpKnowledgeInteraction(@Value("${graphpattern.whirlpoolappliances}") String resultPattern,
                                      @Value("${communicativeact.required.purposes}") List<String> requiredPurposes,
                                      @Value("${communicativeact.satisfied.purposes}") List<String> satisfiedPurposes) {
        super(resultPattern, requiredPurposes, satisfiedPurposes);
//        super(resultPattern);

        log.info("requiredPurposes: " + requiredPurposes);
        log.info("satisfiedPurposes: " + satisfiedPurposes);

        log.info("Result pattern: " + getResultPattern());
    }
}
