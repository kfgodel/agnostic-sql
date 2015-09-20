package ar.com.kfgodel.asql.impl.model.operators;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents the model for a negated expresion where not literal is first
 * Created by tenpines on 19/09/15.
 */
public class NotAfterModel implements AgnosticModel {

    private AgnosticModel negated;

    public AgnosticModel getNegated() {
        return negated;
    }

    @Override
    public String getTemplatePath() {
        return "/operators/_notAfter.ftl";
    }


    public static NotAfterModel create(AgnosticModel negatedModel){
        NotAfterModel model = new NotAfterModel();
        model.negated = negatedModel;
        return model;
    }

}
