package ar.com.kfgodel.asql.impl.model.operators;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents the model for a negated expresion where not literal is first
 * Created by tenpines on 19/09/15.
 */
public class NotBeforeModel implements AgnosticModel {

    private AgnosticModel negated;

    public AgnosticModel getNegated() {
        return negated;
    }

    @Override
    public String getTemplatePath() {
        return "/operators/_notBefore.ftl";
    }


    public static NotBeforeModel create(AgnosticModel negatedModel){
        NotBeforeModel beforeModel = new NotBeforeModel();
        beforeModel.negated = negatedModel;
        return beforeModel;
    }

}
