package ar.com.kfgodel.asql.impl.lang.condition;

import ar.com.kfgodel.asql.api.DataType;
import ar.com.kfgodel.asql.api.condition.NamedColumn;
import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.api.create.ColumnDeclaration;
import ar.com.kfgodel.asql.api.update.ColumnAssignment;
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

    public static NamedColumnImpl create(String columnName) {
        NamedColumnImpl named = new NamedColumnImpl();
        named.columnName = columnName;
        return named;
    }

}
