package ar.com.kfgodel.asql.api.restrictions;

import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.columns.ColumnAssignment;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface NamedColumn {

    QueryCondition isNull();

    QueryCondition isNotNull();

    ColumnAssignment to(Object value);

    ColumnDeclaration typed(DataType dataType);
}
