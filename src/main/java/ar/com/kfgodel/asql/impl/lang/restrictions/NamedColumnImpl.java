package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.lang.column.MinimalColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.update.ColumnAssignmentImpl;

/**
 * Created by kfgodel on 12/07/15.
 */
public class NamedColumnImpl implements NamedColumn {

    private String columnName;

    public String getColumnName() {
        return columnName;
    }

    @Override
    public QueryCondition isNull() {
        return IsNullCondition.create(this);
    }

    @Override
    public QueryCondition isNotNull() {
        return NotNullCondition.create(this);
    }

    @Override
    public ColumnAssignment to(Object value) {
        return ColumnAssignmentImpl.create(columnName, value);
    }

    @Override
    public ColumnDeclaration typed(DataType dataType) {
        return MinimalColumnDeclaration.create(this, dataType);
    }

    @Override
    public QueryCondition isEqualsTo(Object operand) {
        return ColumnDefinedEqualsCondition.create(this, operand);
    }

    public static NamedColumnImpl create(String columnName) {
        NamedColumnImpl named = new NamedColumnImpl();
        named.columnName = columnName;
        return named;
    }

}
