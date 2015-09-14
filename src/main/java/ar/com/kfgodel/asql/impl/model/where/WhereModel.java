package ar.com.kfgodel.asql.impl.model.where;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;

/**
 * Created by tenpines on 13/09/15.
 */
public class WhereModel implements AgnosticModel {

    private PredicateModel predicate;

    public PredicateModel getPredicate() {
        return predicate;
    }

    public void setPredicate(PredicateModel predicate) {
        this.predicate = predicate;
    }

    public boolean getDefined(){
        return predicate != null;
    }

    @Override
    public String getTemplatePath() {
        return "/where/_where.ftl";
    }
    
    public static WhereModel create(){
        WhereModel model = new WhereModel();
        return model;
    }
    
}
