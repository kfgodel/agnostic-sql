package ar.com.kfgodel.asql.api.restrictions;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.operators.Operator;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents the definition of an agnostic restriction/condition
 * Created by kfgodel on 11/07/15.
 */
public interface QueryCondition extends AgnosticConstruct {

    @Override
    AgnosticModel parseModel();

    default QueryCondition and(QueryCondition anotherCondition){
        return Internal.binaryOp(this, Operator.and(), anotherCondition);
    }

    default QueryCondition or(QueryCondition anotherCondition){
        return Internal.binaryOp(this, Operator.or(), anotherCondition);
    }
}
