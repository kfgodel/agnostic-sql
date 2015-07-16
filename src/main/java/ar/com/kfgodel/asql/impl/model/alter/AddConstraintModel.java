package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.constraints.NamedConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class AddConstraintModel extends TableCenteredModel implements AgnosticModel {

    private NamedConstraintDeclarationModel constraint;

    public NamedConstraintDeclarationModel getConstraint() {
        return constraint;
    }

    public void setConstraint(NamedConstraintDeclarationModel constraint) {
        this.constraint = constraint;
    }

    public static AddConstraintModel create(String tableName, NamedConstraintDeclarationModel constraintDeclaration) {
        AddConstraintModel model = new AddConstraintModel();
        model.setTableName(tableName);
        model.constraint = constraintDeclaration;
        return model;
    }

}
