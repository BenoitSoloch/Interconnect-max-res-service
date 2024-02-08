package fr.yncrea.maxresadapter.interractions.whirlpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.PostKnowledgeInteraction;

import java.util.List;

@Component
public class PostWhpDelayCycle extends PostKnowledgeInteraction {
    private final Logger log = LogManager.getLogger();

    public PostWhpDelayCycle(@Value("${graphpattern.whirlpooldelay}") String argumentPattern,
                             @Value("${graphpattern.whirlpoolresultdelay}") String result) {
        super(argumentPattern, result);
    }
}
