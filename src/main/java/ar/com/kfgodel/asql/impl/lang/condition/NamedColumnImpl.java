package ar.com.kfgodel.asql.impl.lang.condition;

import ar.com.kfgodel.asql.api.condition.NamedColumn;
import ar.com.kfgodel.asql.api.condition.QueryCondition;

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

    public static NamedColumnImpl create(String columnName) {
        NamedColumnImpl named = new NamedColumnImpl();
        named.columnName = columnName;
        return named;
    }

}
