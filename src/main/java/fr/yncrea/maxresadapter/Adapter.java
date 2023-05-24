package fr.yncrea.maxresadapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.ReactiveClient;

@Component
public class Adapter {

    private final Logger log = LogManager.getLogger();
    private final ReactiveClient knowledgeEngineClient;

    public Adapter(ReactiveClient knowledgeEngineClient) {
        this.knowledgeEngineClient = knowledgeEngineClient;
    }

    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        this.knowledgeEngineClient.startHandlingInteractions();
    }
}
