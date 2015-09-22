package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.FkConstraintDeclaration;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.NamedConstraintDeclarationModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class FkConstraintDeclarationImpl implements FkConstraintDeclaration {

    private ColumnDefinedFkImpl previousNode;

    private String referencedTableName;

    @Override
    public NamedConstraintDeclarationModel parseModel() {
        ConstraintDeclarationModel model = ConstraintDeclarationModel.create("FOREIGN KEY");
        model.addColumn(previousNode.getSourceColumn().parseModel());
        model.setTail("REFERENCES " + referencedTableName);
        return NamedConstraintDeclarationModel.create(previousNode.getConstraintName(), model);
    }

    public static FkConstraintDeclarationImpl create(ColumnDefinedFkImpl previousNode, String referencedTable) {
        FkConstraintDeclarationImpl constraint = new FkConstraintDeclarationImpl();
        constraint.previousNode = previousNode;
        constraint.referencedTableName = referencedTable;
        return constraint;
    }

}
