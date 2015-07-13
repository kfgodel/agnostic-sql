package ar.com.kfgodel.asql.impl.lang.condition;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.impl.tree.PredicateModel;
import ar.com.kfgodel.asql.impl.value.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.value.NullOperand;

/**
 * Created by kfgodel on 12/07/15.
 */
public class IsNullCondition implements QueryCondition {

    private NamedColumnImpl namedColumn;

    public static IsNullCondition create(NamedColumnImpl namedColumn) {
        IsNullCondition condition = new IsNullCondition();
        condition.namedColumn = namedColumn;
        return condition;
    }

    @Override
    public PredicateModel parseModel() {
        return PredicateModel.create(ColumnReferenceModel.create(namedColumn.getColumnName()), "IS", NullOperand.create());
    }
}
