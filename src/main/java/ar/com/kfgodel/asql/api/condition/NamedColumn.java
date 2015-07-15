package ar.com.kfgodel.asql.api.condition;

import ar.com.kfgodel.asql.api.DataType;
import ar.com.kfgodel.asql.api.create.ColumnDeclaration;
import ar.com.kfgodel.asql.api.update.ColumnAssignment;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface NamedColumn {

    QueryCondition isNull();

    QueryCondition isNotNull();

    ColumnAssignment to(Object value);

    ColumnDeclaration typed(DataType dataType);
}
