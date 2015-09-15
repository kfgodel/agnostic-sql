package ar.com.kfgodel.asql.api.restrictions;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.lang.Parseable;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface NamedColumn extends Parseable {

    QueryCondition isNull();

    QueryCondition isNotNull();

    ColumnAssignment to(Object value);

    ColumnDeclaration typed(DataType dataType);

    QueryCondition isEqualsTo(Object operand);

    QueryCondition isEqualsToColumn(String aColumnName);
}
