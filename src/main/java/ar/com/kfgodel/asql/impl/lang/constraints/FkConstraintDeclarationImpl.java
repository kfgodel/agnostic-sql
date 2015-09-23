package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.FkConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class FkConstraintDeclarationImpl implements FkConstraintDeclaration {

    private ColumnDefinedFkImpl previousNode;

    private TableReference referencedTableName;

    @Override
    public ConstraintDeclarationModel parseModel() {
        ConstraintDeclarationModel model = ConstraintDeclarationModel.create("FOREIGN KEY");
        model.addColumn(previousNode.getSourceColumn().parseModel());
        model.setTail("REFERENCES " + referencedTableName.getTableName());
        model.setOptionalName(previousNode.getConstraint().parseModel());
        return model;
    }

    public static FkConstraintDeclarationImpl create(ColumnDefinedFkImpl previousNode, TableReference referencedTable) {
        FkConstraintDeclarationImpl constraint = new FkConstraintDeclarationImpl();
        constraint.previousNode = previousNode;
        constraint.referencedTableName = referencedTable;
        return constraint;
    }

}
