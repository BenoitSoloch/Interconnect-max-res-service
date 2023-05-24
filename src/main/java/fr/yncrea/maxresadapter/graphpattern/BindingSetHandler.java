package fr.yncrea.maxresadapter.graphpattern;

import org.apache.jena.sparql.core.TriplePath;
import org.apache.jena.sparql.engine.binding.Binding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import world.inetum.dr.knowledge_engine.adapter.interactions.model.GraphPattern;

import java.util.List;
import java.util.Map;

@Component
public class BindingSetHandler {

    private final Logger log = LogManager.getLogger();

    private final GraphPatternValidator graphPatternValidator;
    private final GraphPatternPopulator graphPatternPopulator;
    private final BindingSetMapper bindingSetMapper;

    public BindingSetHandler(
            GraphPatternValidator graphPatternValidator,
            GraphPatternPopulator graphPatternPopulator,
            BindingSetMapper bindingSetMapper
    ) {
        this.graphPatternValidator = graphPatternValidator;
        this.graphPatternPopulator = graphPatternPopulator;
        this.bindingSetMapper = bindingSetMapper;
    }

    public List<TriplePath> populateGraphPattern(List<Map<String, String>> bindingSet, GraphPattern graphPattern) {
        if (!graphPatternValidator.bindingSetMatchesGraphPattern(bindingSet, graphPattern)) {
            throw new IncompleteBindingSetException();
        }

        List<Binding> bindings = this.bindingSetMapper.mapBindingSetToBindingList(bindingSet);

        List<TriplePath> populatedGraphPattern = graphPatternPopulator.populateGraphPatterns(graphPattern, bindings);

        return populatedGraphPattern;
    }

    public boolean checkGraphPatternValidity(List<Map<String, String>> bindingSet, GraphPattern graphPattern){
        if (!graphPatternValidator.bindingSetMatchesGraphPattern(bindingSet, graphPattern)) {
            return false;
        }
        return true;
    }
}
