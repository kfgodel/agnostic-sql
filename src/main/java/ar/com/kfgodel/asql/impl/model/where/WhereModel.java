package ar.com.kfgodel.asql.impl.model.where;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;

/**
 * Created by tenpines on 13/09/15.
 */
public class WhereModel implements AgnosticModel {

    private PredicateModel wherePredicate;

    public PredicateModel getWherePredicate() {
        return wherePredicate;
    }

    public void setWherePredicate(PredicateModel wherePredicate) {
        this.wherePredicate = wherePredicate;
    }

    public boolean getDefined(){
        return wherePredicate != null;
    }

    @Override
    public String getTemplatePath() {
        return "/where/_wherePredicate.ftl";
    }
    
    public static WhereModel create(){
        WhereModel model = new WhereModel();
        return model;
    }
    
}
