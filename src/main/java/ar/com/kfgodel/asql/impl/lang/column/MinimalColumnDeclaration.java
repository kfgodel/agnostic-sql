package ar.com.kfgodel.asql.impl.lang.column;

import ar.com.kfgodel.asql.api.DataType;
import ar.com.kfgodel.asql.api.create.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.condition.NamedColumnImpl;
import ar.com.kfgodel.asql.impl.model.create.ColumnDeclarationModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class MinimalColumnDeclaration implements ColumnDeclaration {

    private NamedColumnImpl namedColumn;
    private DataType columnType;

    @Override
    public ColumnDeclaration nonNullable() {
        return NonNullableDeclaration.create(this);
    }

    @Override
    public ColumnDeclaration nullable() {
        return NullableDeclaration.create(this);
    }

    @Override
    public ColumnDeclaration defaultedTo(Object columnValue) {
        return DefaultedColumnDeclaration.create(this, columnValue);
    }


    @Override
    public ColumnDeclarationModel parseModel() {
        return ColumnDeclarationModel.create(namedColumn.getColumnName(), columnType);
    }

    public static MinimalColumnDeclaration create(NamedColumnImpl namedColumn, DataType columnType) {
        MinimalColumnDeclaration columnDeclaration = new MinimalColumnDeclaration();
        columnDeclaration.namedColumn = namedColumn;
        columnDeclaration.columnType = columnType;
        return columnDeclaration;
    }

}
