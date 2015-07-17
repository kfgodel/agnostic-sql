package ar.com.kfgodel.asql.api.restrictions;

import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;
import ar.com.kfgodel.asql.impl.lang.Parseable;

/**
 * This type represents the definition of an agnostic restriction/condition
 * Created by kfgodel on 11/07/15.
 */
public interface QueryCondition extends Parseable {

    @Override
    PredicateModel parseModel();

    QueryCondition and(QueryCondition anotherCondition);

    QueryCondition or(QueryCondition anotherCondition);
}
