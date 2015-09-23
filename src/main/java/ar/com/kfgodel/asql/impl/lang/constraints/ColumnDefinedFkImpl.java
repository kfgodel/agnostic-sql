package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.ColumnDefinedFk;
import ar.com.kfgodel.asql.api.constraints.FkConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.lang.references.ConstraintReference;

/**
 * Created by kfgodel on 16/07/15.
 */
public class ColumnDefinedFkImpl implements ColumnDefinedFk {

    private NamedConstraintImpl previousNode;
    private ColumnReference sourceColumn;


    public ConstraintReference getConstraint(){
        return previousNode.getConstraint();
    }

    public ColumnReference getSourceColumn() {
        return sourceColumn;
    }

    @Override
    public FkConstraintDeclaration to(String referencedTableName) {
        return FkConstraintDeclarationImpl.create(this, Internal.table(referencedTableName));
    }

    public static ColumnDefinedFkImpl create(NamedConstraintImpl previousNode, ColumnReference sourceColumn) {
        ColumnDefinedFkImpl definedFk = new ColumnDefinedFkImpl();
        definedFk.sourceColumn = sourceColumn;
        definedFk.previousNode = previousNode;
        return definedFk;
    }

}
