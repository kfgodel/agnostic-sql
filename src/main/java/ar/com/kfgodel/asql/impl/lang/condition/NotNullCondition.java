package ar.com.kfgodel.asql.impl.lang.condition;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.impl.tree.PredicateNode;
import ar.com.kfgodel.asql.impl.value.ColumnReference;
import ar.com.kfgodel.asql.impl.value.NullOperand;

/**
 * Created by kfgodel on 12/07/15.
 */
public class NotNullCondition implements QueryCondition {

    private NamedColumnImpl namedColumn;

    public static NotNullCondition create(NamedColumnImpl namedColumn) {
        NotNullCondition condition = new NotNullCondition();
        condition.namedColumn = namedColumn;
        return condition;
    }

    @Override
    public PredicateNode getRepresentationNode() {
        return PredicateNode.create(ColumnReference.create(namedColumn.getColumnName()), "IS NOT", NullOperand.create());
    }
}
