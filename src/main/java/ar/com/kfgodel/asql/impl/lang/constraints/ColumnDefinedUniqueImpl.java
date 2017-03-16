package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.ConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.UniqueDefinitionModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tenpines on 22/09/15.
 */
public class ColumnDefinedUniqueImpl implements ConstraintDeclaration {

    private List<ColumnReference> columns;
    private NamedConstraintImpl previousNode;

    public static ColumnDefinedUniqueImpl create(NamedConstraintImpl previousNode, List<ColumnReference> columns){
        ColumnDefinedUniqueImpl unique = new ColumnDefinedUniqueImpl();
        unique.previousNode = previousNode;
        unique.columns = columns;
        return unique;
    }

    @Override
    public ConstraintDeclarationModel parseModel() {
        ConstraintDeclarationModel declarationModel = ConstraintDeclarationModel.create(UniqueDefinitionModel.create(parseColumnModels()));
        declarationModel.setIdentification(previousNode.getConstraintReference().parseModel());
        return declarationModel;
    }

    private List<ColumnReferenceModel> parseColumnModels() {
        return columns.stream()
                .map(ColumnReference::parseModel)
                    .collect(Collectors.toList());
    }
}
