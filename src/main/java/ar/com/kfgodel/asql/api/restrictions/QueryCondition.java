package ar.com.kfgodel.asql.api.restrictions;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.restrictions.BinaryOperatorCondition;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;

/**
 * This type represents the definition of an agnostic restriction/condition
 * Created by kfgodel on 11/07/15.
 */
public interface QueryCondition extends AgnosticConstruct {

    @Override
    PredicateModel parseModel();

    default QueryCondition and(QueryCondition anotherCondition){
        return BinaryOperatorCondition.create(this, "AND", anotherCondition);
    };

    default QueryCondition or(QueryCondition anotherCondition){
        return BinaryOperatorCondition.create(this, "OR", anotherCondition);
    };
}
