package fr.yncrea.maxresadapter.interractions.whirlpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.AskKnowledgeInteraction;

import java.util.List;

@Component
public class AskRegistrationWhpInteraction extends AskKnowledgeInteraction {
    private final Logger log = LogManager.getLogger();
    public AskRegistrationWhpInteraction(@Value("${graphpattern.whirlpoolregister}")  String resultPattern,
                                         @Value("${communicativeact.required.purposes}") List<String> requiredPurposes,
                                         @Value("${communicativeact.satisfied.purposes}") List<String> satisfiedPurposes) {
        super(resultPattern, requiredPurposes, satisfiedPurposes);

        log.info("Result pattern: " + getResultPattern());
    }
}
