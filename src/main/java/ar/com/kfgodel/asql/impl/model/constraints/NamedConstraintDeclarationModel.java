package ar.com.kfgodel.asql.impl.model.constraints;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class NamedConstraintDeclarationModel implements AgnosticModel {

    private String name;
    private ConstraintDeclarationModel declaration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstraintDeclarationModel getDeclaration() {
        return declaration;
    }

    public void setDeclaration(ConstraintDeclarationModel declaration) {
        this.declaration = declaration;
    }

    public static NamedConstraintDeclarationModel create(String name, ConstraintDeclarationModel declaration) {
        NamedConstraintDeclarationModel model = new NamedConstraintDeclarationModel();
        model.name = name;
        model.declaration = declaration;
        return model;
    }

    @Override
    public String getTemplatePath() {
        throw new UnsupportedOperationException("No template defined for this mnodel");
    }
}
