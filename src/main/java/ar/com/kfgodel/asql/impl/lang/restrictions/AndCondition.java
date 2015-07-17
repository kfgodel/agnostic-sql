package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class AndCondition implements QueryCondition {

    private QueryCondition leftCondition;
    private QueryCondition rightCondition;

    @Override
    public PredicateModel parseModel() {
        return PredicateModel.create(leftCondition.parseModel(),"AND",rightCondition.parseModel());
    }

    @Override
    public QueryCondition and(QueryCondition anotherCondition) {
        return AndCondition.create(this, anotherCondition);
    }

    public static AndCondition create(QueryCondition leftCondition, QueryCondition rightCondition) {
        AndCondition andCondition = new AndCondition();
        andCondition.leftCondition = leftCondition;
        andCondition.rightCondition = rightCondition;
        return andCondition;
    }

    @Override
    public QueryCondition or(QueryCondition anotherCondition) {
        return OrCondition.create(this, anotherCondition);
    }
}
