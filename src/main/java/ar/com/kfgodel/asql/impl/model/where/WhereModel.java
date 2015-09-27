package ar.com.kfgodel.asql.impl.model.where;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * Created by tenpines on 13/09/15.
 */
public class WhereModel implements AgnosticModel {

    private AgnosticModel predicate;

    public AgnosticModel getPredicate() {
        return predicate;
    }

    public void setPredicate(AgnosticModel predicate) {
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
