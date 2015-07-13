package ar.com.kfgodel.asql.impl.lang.condition;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.impl.tree.PredicateNode;

/**
 * Created by kfgodel on 12/07/15.
 */
public class IsNullCondition implements QueryCondition {

    private NamedColumnImpl namedColumn;

    @Override
    public PredicateNode getPredicateNode() {
        return PredicateNode.create(namedColumn.getColumnName(), "IS", "NULL");
    }

    public static IsNullCondition create(NamedColumnImpl namedColumn) {
        IsNullCondition condition = new IsNullCondition();
        condition.namedColumn = namedColumn;
        return condition;
    }

}
