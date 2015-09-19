package ar.com.kfgodel.asql.api.restrictions;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.types.DataType;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface NamedColumn extends AgnosticConstruct {

    QueryCondition isNull();

    QueryCondition isNotNull();

    ColumnAssignment to(Object value);

    ColumnDeclaration typed(DataType dataType);

    QueryCondition isEqualsTo(Object operand);

    QueryCondition isEqualsToColumn(String aColumnName);

    QueryCondition isLessThan(Object value);

    QueryCondition isLessThanColumn(String aColumnName);

    QueryCondition isGreaterThan(Object value);

    QueryCondition isGreaterThanColumn(String aColumnName);

    QueryCondition isLessOrEqualThan(Object value);

    QueryCondition isLessThanOrEqualColumn(String aColumnName);

    QueryCondition isGreaterOrEqualThan(Object value);

    QueryCondition isGreaterOrEqualThanColumn(String aColumnName);

    QueryCondition isLike(String pattern);

    QueryCondition startsWith(String prefix);

    QueryCondition endsWith(String suffix);

    QueryCondition contains(String part);
}
