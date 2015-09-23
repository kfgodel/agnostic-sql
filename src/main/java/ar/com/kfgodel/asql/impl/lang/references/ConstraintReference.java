package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.references.ConstraintReferenceModel;

/**
 * This type represents language reference to a table constraint
 * Created by tenpines on 22/09/15.
 */
public class ConstraintReference implements AgnosticConstruct {

    private String name;

    public String getName() {
        return name;
    }

    public static ConstraintReference create(String constraintName){
        ConstraintReference reference = new ConstraintReference();
        reference.name = constraintName;
        return reference;
    }

    @Override
    public ConstraintReferenceModel parseModel() {
        return ConstraintReferenceModel.create(name);
    }
}
