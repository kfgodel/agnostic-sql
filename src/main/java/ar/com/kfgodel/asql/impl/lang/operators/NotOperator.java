package ar.com.kfgodel.asql.impl.lang.operators;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

import java.util.function.Function;

/**
 * Implementation that delegates in a function to set the operator position on parsing
 * Created by tenpines on 19/09/15.
 */
public class NotOperator implements AgnosticConstruct {

    private AgnosticConstruct negatedConstruct;
    private Function<AgnosticModel, AgnosticModel> negatorFunction;
    
    @Override
    public AgnosticModel parseModel() {
        return negatorFunction.apply(negatedConstruct.parseModel());
    }

    public static NotOperator create(AgnosticConstruct negated, Function<AgnosticModel, AgnosticModel> negator){
        NotOperator operator = new NotOperator();
        operator.negatedConstruct = negated;
        operator.negatorFunction = negator;
        return operator;
    }

}
