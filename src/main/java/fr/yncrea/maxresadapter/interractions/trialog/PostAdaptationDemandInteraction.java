//package fr.yncrea.maxresadapter.interractions.trialog;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import world.inetum.dr.knowledge_engine.adapter.interactions.model.ReactKnowledgeInteraction;
//
//import javax.validation.constraints.NotNull;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;

//@Component
//public class PostAdaptationDemandInteraction extends ReactKnowledgeInteraction {
//    private final Logger log = LogManager.getLogger();
//    protected PostAdaptationDemandInteraction(@Value("${graphpattern.adaptationdemand}") String argumentPattern) {
//        super(argumentPattern);
//    }
//
//    @Override
//    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> request) {
//        log.info("[ PostAdaptationDemandInteraction ] Received: " + request);
//
//        return Optional.empty();
//    }
//}
