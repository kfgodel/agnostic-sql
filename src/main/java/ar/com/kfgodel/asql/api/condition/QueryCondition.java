package ar.com.kfgodel.asql.api.condition;

import ar.com.kfgodel.asql.impl.tree.PredicateModel;
import ar.com.kfgodel.asql.impl.tree.Parseable;

/**
 * This type represents the definition of an agnostic restriction/condition
 * Created by kfgodel on 11/07/15.
 */
public interface QueryCondition extends Parseable {

    @Override
    PredicateModel parseModel();
}
