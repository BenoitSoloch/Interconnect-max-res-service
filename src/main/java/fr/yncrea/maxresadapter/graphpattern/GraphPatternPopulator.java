package fr.yncrea.maxresadapter.graphpattern;

import org.apache.jena.sparql.core.Substitute;
import org.apache.jena.sparql.core.TriplePath;
import org.apache.jena.sparql.engine.binding.Binding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.GraphPattern;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphPatternPopulator {

    private final Logger log = LogManager.getLogger();

    public List<TriplePath> populateGraphPatterns(GraphPattern graphPattern, List<Binding> bindings) {
        log.debug("Populating graph patterns : {}", bindings);
        return bindings
                .stream()
                .map(binding -> populateGraphPattern(graphPattern, binding))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<TriplePath> populateGraphPattern(GraphPattern graphPattern, Binding binding) {
        return graphPattern.getGraphPattern().getPattern().getList().stream()
                .map(tp -> Substitute.substitute(tp, binding))
                .collect(Collectors.toList());
    }
}
