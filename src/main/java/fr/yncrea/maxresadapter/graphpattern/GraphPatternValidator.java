package fr.yncrea.maxresadapter.graphpattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.GraphPattern;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class GraphPatternValidator {

    private final Logger log = LogManager.getLogger();

    public boolean bindingSetMatchesGraphPattern(
            final List<Map<String, String>> bindingSet,
            final GraphPattern graphPattern
    ) {
        log.debug("Validating binding set : {}", bindingSet);
        return bindingSet.stream()
                .allMatch(b -> bindingMatchesPattern(b, graphPattern.getVariables()));
    }

    private boolean bindingMatchesPattern(
            final Map<String, String> binding,
            final Set<String> variables
    ) {
        return variables.stream()
                .allMatch(v -> binding.keySet().stream()
                        .anyMatch(v::contains));
    }
}
