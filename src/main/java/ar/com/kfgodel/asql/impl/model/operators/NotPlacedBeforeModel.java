package ar.com.kfgodel.asql.impl.model.operators;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

/**
 * This type represents the model for a negated expresion where not literal is first
 * Created by tenpines on 19/09/15.
 */
public class NotPlacedBeforeModel implements AgnosticModel, NullabilityModel {

    private AgnosticModel negated;

    public AgnosticModel getNegated() {
        return negated;
    }

    @Override
    public String getTemplatePath() {
        return "/operators/_notBefore.ftl";
    }

    public static NotPlacedBeforeModel create(AgnosticModel negatedModel) {
        NotPlacedBeforeModel beforeModel = new NotPlacedBeforeModel();
        beforeModel.negated = negatedModel;
        return beforeModel;
    }

}
