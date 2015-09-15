package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.lang.Parseable;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;

/**
 * This type represents a condition construct where the column is named as left had operator
 * Created by tenpines on 14/09/15.
 */
public class ColumnDefinedEqualsCondition implements QueryCondition {

    private NamedColumnImpl namedColumn;
    private Parseable operand;

    @Override
    public PredicateModel parseModel() {
        return PredicateModel.create(namedColumn.parseModel(), "=", operand.parseModel());
    }

    @Override
    public QueryCondition and(QueryCondition anotherCondition) {
        return AndCondition.create(this, anotherCondition);
    }

    @Override
    public QueryCondition or(QueryCondition anotherCondition) {
        return OrCondition.create(this, anotherCondition);
    }
    
    public static ColumnDefinedEqualsCondition create(NamedColumnImpl namedColumn, Parseable operand){
        ColumnDefinedEqualsCondition condition = new ColumnDefinedEqualsCondition();
        condition.namedColumn = namedColumn;
        condition.operand = operand;
        return condition;
    }


}