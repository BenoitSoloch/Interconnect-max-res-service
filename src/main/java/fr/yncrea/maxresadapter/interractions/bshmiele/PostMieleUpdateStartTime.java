package fr.yncrea.maxresadapter.interractions.bshmiele;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.PostKnowledgeInteraction;

@Component
public class PostMieleUpdateStartTime extends PostKnowledgeInteraction {
    private final Logger log = LogManager.getLogger();
    protected PostMieleUpdateStartTime(@Value("${graphpattern.updatestarttime}") String argumentPattern) {
        super(argumentPattern);
    }
}
