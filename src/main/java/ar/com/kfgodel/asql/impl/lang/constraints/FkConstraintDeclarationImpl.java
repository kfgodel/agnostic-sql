package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.FkConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.FkDefinitionModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * Created by kfgodel on 16/07/15.
 */
public class FkConstraintDeclarationImpl implements FkConstraintDeclaration {

    private ColumnDefinedFkImpl previousNode;

    private TableReference referencedTable;

    @Override
    public ConstraintDeclarationModel parseModel() {
        ArrayList<ColumnReferenceModel> sourceColumns = Lists.newArrayList(previousNode.getSourceColumn().parseModel());
        FkDefinitionModel fkDefinition = FkDefinitionModel.create(sourceColumns, referencedTable.parseModel());
        ConstraintDeclarationModel fkDeclarationModel = ConstraintDeclarationModel.create(fkDefinition);
        fkDeclarationModel.setIdentification(previousNode.getConstraint().parseModel());
        return fkDeclarationModel;
    }

    public static FkConstraintDeclarationImpl create(ColumnDefinedFkImpl previousNode, TableReference referencedTable) {
        FkConstraintDeclarationImpl constraint = new FkConstraintDeclarationImpl();
        constraint.previousNode = previousNode;
        constraint.referencedTable = referencedTable;
        return constraint;
    }

}
