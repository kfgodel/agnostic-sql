package ar.com.kfgodel.asql.impl.lang.column;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class DefaultedColumnDeclaration implements ColumnDeclaration {
    private ColumnDeclaration previousNode;
    private Object defaultValue;

    @Override
    public ColumnDeclaration nonNullable() {
        return NonNullableDeclaration.create(this);
    }

    @Override
    public ColumnDeclaration defaultedTo(Object columnValue) {
        return DefaultedColumnDeclaration.create(previousNode, columnValue);
    }

    @Override
    public ColumnDeclaration nullable() {
        return NullableDeclaration.create(this);
    }

    @Override
    public ColumnDeclarationModel parseModel() {
        ColumnDeclarationModel columnModel = previousNode.parseModel();
        columnModel.setDefaultValue(ExplicitValueModel.create(defaultValue));
        return columnModel;
    }

    public static DefaultedColumnDeclaration create(ColumnDeclaration previousNode, Object value) {
        DefaultedColumnDeclaration declaration = new DefaultedColumnDeclaration();
        declaration.previousNode = previousNode;
        declaration.defaultValue = value;
        return declaration;
    }

}
