package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;

/**
 * Created by kfgodel on 17/07/15.
 */
public class OrCondition implements QueryCondition {

    private QueryCondition leftCondition;
    private QueryCondition rightCondition;

    @Override
    public PredicateModel parseModel() {
        return PredicateModel.create(leftCondition.parseModel(),"OR",rightCondition.parseModel());
    }

    @Override
    public QueryCondition and(QueryCondition anotherCondition) {
        return AndCondition.create(this, anotherCondition);
    }

    @Override
    public QueryCondition or(QueryCondition anotherCondition) {
        return OrCondition.create(this, anotherCondition);
    }

    public static OrCondition create(QueryCondition leftCondition, QueryCondition rightCondition) {
        OrCondition orCondition = new OrCondition();
        orCondition.leftCondition = leftCondition;
        orCondition.rightCondition = rightCondition;
        return orCondition;
    }

}
