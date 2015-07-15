package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;
import ar.com.kfgodel.asql.impl.model.value.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.value.NullOperand;

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
