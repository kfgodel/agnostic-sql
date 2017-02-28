package ar.com.kfgodel.asql.impl.model.operators;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

/**
 * This type represents the model for a negated expresion where not literal is first
 * Created by tenpines on 19/09/15.
 */
public class NotPlacedAfterModel implements AgnosticModel, NullabilityModel {

    private AgnosticModel negated;

    public AgnosticModel getNegated() {
        return negated;
    }

    @Override
    public String getTemplatePath() {
        return "/operators/_notAfter.ftl";
    }


    public static NotPlacedAfterModel create(AgnosticModel negatedModel) {
        NotPlacedAfterModel model = new NotPlacedAfterModel();
        model.negated = negatedModel;
        return model;
    }

}
