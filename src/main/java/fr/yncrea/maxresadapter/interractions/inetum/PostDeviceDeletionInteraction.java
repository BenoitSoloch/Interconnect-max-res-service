package fr.yncrea.maxresadapter.interractions.inetum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.PostKnowledgeInteraction;

@Component
public class PostDeviceDeletionInteraction  extends PostKnowledgeInteraction {
    public PostDeviceDeletionInteraction(@Value("${graphpattern.devicedeletion}") String argumentPattern,
                                         @Value("${graphpattern.result}") String result) {
        super(argumentPattern, result);
    }
}
