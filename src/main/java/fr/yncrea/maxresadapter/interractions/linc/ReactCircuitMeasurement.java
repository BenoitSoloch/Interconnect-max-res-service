package fr.yncrea.maxresadapter.interractions.linc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.ReactKnowledgeInteraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ReactCircuitMeasurement extends ReactKnowledgeInteraction {

    private final Logger log = LogManager.getLogger();
    protected ReactCircuitMeasurement(@Value("${graphpattern.circuitmeasurement}") String argumentPattern) {
        super(argumentPattern);
    }

    @Override
    public Optional<List<Map<String, String>>> handle(List<Map<String, String>> request) {
        log.info("-- ReactCircuitMeasurement: " + request);

        for (Map<String, String> mapSet : request) {
            float energy_active_exported = Float.parseFloat(mapSet.get("energy_active_exported"));
            float energy_active_imported = Float.parseFloat(mapSet.get("energy_active_imported"));
            float value = energy_active_exported - energy_active_imported;
            log.info("-- energy_active_exported: " + energy_active_exported);
            log.info("-- energy_active_imported: " + energy_active_imported);
            log.info("-- Final Value: " + value);
        }


        return Optional.empty();
    }
}
