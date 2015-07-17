package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;
import ar.com.kfgodel.asql.impl.model.value.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.value.NullOperand;

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
    public PredicateModel parseModel() {
        return PredicateModel.create(ColumnReferenceModel.create(namedColumn.getColumnName()), "IS NOT", NullOperand.create());
    }

    @Override
    public QueryCondition and(QueryCondition anotherCondition) {
        return AndCondition.create(this, anotherCondition);
    }

    @Override
    public QueryCondition or(QueryCondition anotherCondition) {
        return OrCondition.create(this, anotherCondition);
    }
}
