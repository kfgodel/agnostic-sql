package ar.com.kfgodel.asql.impl.lang.column;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.lang.restrictions.NamedColumnImpl;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;

import static ar.com.kfgodel.asql.impl.lang.column.NullabilityDeclaration.makeNonNullable;
import static ar.com.kfgodel.asql.impl.lang.column.NullabilityDeclaration.makeNullable;

/**
 * Created by kfgodel on 14/07/15.
 */
public class MinimalColumnDeclaration implements ColumnDeclaration {

    private NamedColumnImpl namedColumn;
    private DataType columnType;

    @Override
    public ColumnDeclaration nonNullable() {
        return makeNonNullable(this);
    }

    @Override
    public ColumnDeclaration nullable() {
        return makeNullable(this);
    }

    @Override
    public ColumnDeclaration defaultedTo(Object columnValue) {
        return DefaultedColumnDeclaration.create(this, columnValue);
    }


    @Override
    public ColumnDeclarationModel parseModel() {
        return ColumnDeclarationModel.create(namedColumn.parseModel(), columnType.parseModel());
    }

    public static MinimalColumnDeclaration create(NamedColumnImpl namedColumn, DataType columnType) {
        MinimalColumnDeclaration columnDeclaration = new MinimalColumnDeclaration();
        columnDeclaration.namedColumn = namedColumn;
        columnDeclaration.columnType = columnType;
        return columnDeclaration;
    }

}
