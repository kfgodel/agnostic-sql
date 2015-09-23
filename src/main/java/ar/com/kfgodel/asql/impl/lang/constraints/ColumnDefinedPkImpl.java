package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.ConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.PkDefinitionModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tenpines on 22/09/15.
 */
public class ColumnDefinedPkImpl implements ConstraintDeclaration {

    private NamedConstraintImpl previousNode;
    private List<ColumnReference> columns;

    public static ColumnDefinedPkImpl create(NamedConstraintImpl previousNode, List<ColumnReference> columns) {
        ColumnDefinedPkImpl pk = new ColumnDefinedPkImpl();
        pk.previousNode = previousNode;
        pk.columns = columns;
        return pk;
    }

    @Override
    public ConstraintDeclarationModel parseModel() {
        PkDefinitionModel pkDefinition = PkDefinitionModel.create(parseColumnModels());
        ConstraintDeclarationModel declarationModel = ConstraintDeclarationModel.create(pkDefinition);
        declarationModel.setIdentification(previousNode.getConstraint().parseModel());
        return declarationModel;
    }

    private List<ColumnReferenceModel> parseColumnModels() {
        return columns.stream()
                .map(ColumnReference::parseModel)
                .collect(Collectors.toList());
    }
}
