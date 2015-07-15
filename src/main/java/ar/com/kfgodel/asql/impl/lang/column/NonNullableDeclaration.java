package ar.com.kfgodel.asql.impl.lang.column;

import ar.com.kfgodel.asql.api.create.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.model.create.ColumnDeclarationModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class NonNullableDeclaration implements ColumnDeclaration {
    private ColumnDeclaration previousNode;

    @Override
    public ColumnDeclaration nonNullable() {
        return this;
    }

    @Override
    public ColumnDeclaration defaultedTo(Object columnValue) {
        return DefaultedColumnDeclaration.create(this, columnValue);
    }

    @Override
    public ColumnDeclaration nullable() {
        return NullableDeclaration.create(previousNode);
    }

    @Override
    public ColumnDeclarationModel parseModel() {
        ColumnDeclarationModel columnModel = previousNode.parseModel();
        columnModel.setNullity("NOT NULL");
        return columnModel;
    }

    public static NonNullableDeclaration create(ColumnDeclaration previousNode) {
        NonNullableDeclaration declaration = new NonNullableDeclaration();
        declaration.previousNode = previousNode;
        return declaration;
    }

}
