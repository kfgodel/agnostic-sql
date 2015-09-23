package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * Created by tenpines on 22/09/15.
 */
public class ConstraintReferenceModel implements AgnosticModel {

    private String name;

    public String getName() {
        return name;
    }

    public static ConstraintReferenceModel create(String constraintName){
        ConstraintReferenceModel reference = new ConstraintReferenceModel();
        reference.name = constraintName;
        return reference;
    }

    @Override
    public String getTemplatePath() {
        return "/references/_constraint.ftl";
    }
}
