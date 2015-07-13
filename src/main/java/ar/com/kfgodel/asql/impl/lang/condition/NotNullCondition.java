package ar.com.kfgodel.asql.impl.lang.condition;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.impl.tree.PredicateNode;

/**
 * Created by kfgodel on 12/07/15.
 */
public class NotNullCondition implements QueryCondition {

    private NamedColumnImpl namedColumn;

    @Override
    public PredicateNode getPredicateNode() {
        return PredicateNode.create(namedColumn.getColumnName(), "IS NOT", "NULL");
    }

    public static NotNullCondition create(NamedColumnImpl namedColumn) {
        NotNullCondition condition = new NotNullCondition();
        condition.namedColumn = namedColumn;
        return condition;
    }

}
