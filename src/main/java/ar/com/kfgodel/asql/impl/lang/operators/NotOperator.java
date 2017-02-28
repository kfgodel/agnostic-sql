package ar.com.kfgodel.asql.impl.lang.operators;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.nullability.NullabilityConstraint;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

import java.util.function.Function;

/**
 * Implementation that delegates in a function to set the operator position on parsing
 * Created by tenpines on 19/09/15.
 */
public class NotOperator<T extends AgnosticConstruct> implements AgnosticConstruct, NullabilityConstraint {

    private T negatedConstruct;
    private Function<AgnosticModel, NullabilityModel> positionerFunction;
    
    @Override
    public NullabilityModel parseModel() {
        AgnosticModel negatedModel = negatedConstruct.parseModel();
        return positionerFunction.apply(negatedModel);
    }

    public static <T extends AgnosticConstruct> NotOperator<T> create(T negated, Function<AgnosticModel, NullabilityModel> positioner) {
        NotOperator operator = new NotOperator();
        operator.negatedConstruct = negated;
        operator.positionerFunction = positioner;
        return operator;
    }

}
