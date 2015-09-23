package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.ConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.PkDefinitionModel;

/**
 * Created by tenpines on 22/09/15.
 */
public class ColumnDefinedPkImpl implements ConstraintDeclaration {

    private NamedConstraintImpl previousNode;
    private ColumnReference column;

    public static ColumnDefinedPkImpl create(NamedConstraintImpl previousNode, ColumnReference column) {
        ColumnDefinedPkImpl pk = new ColumnDefinedPkImpl();
        pk.previousNode = previousNode;
        pk.column = column;
        return pk;
    }

    @Override
    public ConstraintDeclarationModel parseModel() {
        ConstraintDeclarationModel declarationModel = ConstraintDeclarationModel.create(PkDefinitionModel.create(column.parseModel()));
        declarationModel.setIdentification(previousNode.getConstraint().parseModel());
        return declarationModel;
    }
}
