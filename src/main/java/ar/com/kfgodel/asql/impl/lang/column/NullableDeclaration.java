package ar.com.kfgodel.asql.impl.lang.column;

import ar.com.kfgodel.asql.api.create.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.model.create.ColumnDeclarationModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class NullableDeclaration implements ColumnDeclaration {

    private ColumnDeclaration previousNode;

    @Override
    public ColumnDeclaration nonNullable() {
        return NonNullableDeclaration.create(previousNode);
    }

    @Override
    public ColumnDeclaration defaultedTo(Object columnValue) {
        return DefaultedColumnDeclaration.create(this, columnValue);
    }

    @Override
    public ColumnDeclaration nullable() {
        return this;
    }

    @Override
    public ColumnDeclarationModel parseModel() {
        ColumnDeclarationModel columnModel = previousNode.parseModel();
        columnModel.setNullity("NULL");
        return columnModel;
    }

    public static NullableDeclaration create(ColumnDeclaration previousNode) {
        NullableDeclaration declaration = new NullableDeclaration();
        declaration.previousNode = previousNode;
        return declaration;
    }
}
