package fr.yncrea.maxresadapter.interractions.inetum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.PostKnowledgeInteraction;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.ReactKnowledgeInteraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PostDeviceRegistrationInteraction extends PostKnowledgeInteraction {

    public PostDeviceRegistrationInteraction(@Value("${graphpattern.deviceregistration}") String argumentPattern,
                                             @Value("${graphpattern.result}") String result) {
        super(argumentPattern, result);
    }
}
