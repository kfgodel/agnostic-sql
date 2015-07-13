package ar.com.kfgodel.asql.api.condition;

import ar.com.kfgodel.asql.impl.tree.PredicateNode;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface QueryCondition {
    /**
     * @return The abstract representation of this condition state
     */
    PredicateNode getPredicateNode();
}
