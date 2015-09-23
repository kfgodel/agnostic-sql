package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class AddConstraintModel extends TableCenteredModel implements AgnosticModel {

    private ConstraintDeclarationModel constraint;

    public ConstraintDeclarationModel getConstraint() {
        return constraint;
    }

    public void setConstraint(ConstraintDeclarationModel constraint) {
        this.constraint = constraint;
    }

    public static AddConstraintModel create(TableReferenceModel table, ConstraintDeclarationModel constraintDeclaration) {
        AddConstraintModel model = new AddConstraintModel();
        model.setTable(table);
        model.constraint = constraintDeclaration;
        return model;
    }

    @Override
    public String getTemplatePath() {
        return "/alter/add_constraint.ftl";
    }
}
