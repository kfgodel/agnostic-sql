package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.lang.column.MinimalColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.lang.references.ListLiteralReference;
import ar.com.kfgodel.asql.impl.lang.references.LiteralReference;
import ar.com.kfgodel.asql.impl.lang.references.NullReference;
import ar.com.kfgodel.asql.impl.lang.update.ColumnAssignmentImpl;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.Collection;

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
        return BinaryOperatorCondition.create(this, "IS", NullReference.create());
    }

    @Override
    public QueryCondition isNotNull() {
        return BinaryOperatorCondition.create(this,"IS NOT", NullReference.create());
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
        return BinaryOperatorCondition.create(this, "=", LiteralReference.create(operand));
    }

    @Override
    public QueryCondition isEqualsToColumn(String aColumnName) {
        return BinaryOperatorCondition.create(this, "=", ColumnReference.create(aColumnName));
    }

    @Override
    public QueryCondition isNotEqualsTo(Object value) {
        return BinaryOperatorCondition.create(this, "<>", LiteralReference.create(value));
    }

    @Override
    public QueryCondition isNotEqualsToColumn(String aColumnName) {
        return BinaryOperatorCondition.create(this, "<>", ColumnReference.create(aColumnName));
    }



    @Override
    public QueryCondition isLessThan(Object value) {
        return BinaryOperatorCondition.create(this, "<", LiteralReference.create(value));
    }

    @Override
    public QueryCondition isLessThanColumn(String aColumnName) {
        return BinaryOperatorCondition.create(this, "<", ColumnReference.create(aColumnName));
    }

    @Override
    public QueryCondition isGreaterThan(Object value) {
        return BinaryOperatorCondition.create(this, ">", LiteralReference.create(value));
    }

    @Override
    public QueryCondition isGreaterThanColumn(String aColumnName) {
        return BinaryOperatorCondition.create(this, ">", ColumnReference.create(aColumnName));
    }

    @Override
    public QueryCondition isLessOrEqualThan(Object value) {
        return BinaryOperatorCondition.create(this, "<=", LiteralReference.create(value));
    }

    @Override
    public QueryCondition isLessThanOrEqualColumn(String aColumnName) {
        return BinaryOperatorCondition.create(this, "<=", ColumnReference.create(aColumnName));
    }

    @Override
    public QueryCondition isGreaterOrEqualThan(Object value) {
        return BinaryOperatorCondition.create(this, ">=", LiteralReference.create(value));
    }

    @Override
    public QueryCondition isGreaterOrEqualThanColumn(String aColumnName) {
        return BinaryOperatorCondition.create(this, ">=", ColumnReference.create(aColumnName));
    }

    @Override
    public QueryCondition isLike(String pattern) {
        return BinaryOperatorCondition.create(this, "LIKE", LiteralReference.create(pattern));
    }

    @Override
    public QueryCondition isNotLike(String pattern) {
        return BinaryOperatorCondition.create(this, "NOT LIKE", LiteralReference.create(pattern));
    }

    @Override
    public QueryCondition doesNotContain(String substring) {
        return isNotLike("%" + substring + "%");
    }

    @Override
    public QueryCondition doesNotEndWith(String suffix) {
        return isNotLike("%" + suffix);
    }

    @Override
    public QueryCondition doesNotStartWith(String prefix) {
        return isNotLike(prefix + "%");
    }

    @Override
    public QueryCondition startsWith(String prefix) {
        return isLike(prefix + "%");
    }

    @Override
    public QueryCondition endsWith(String suffix) {
        return isLike("%" + suffix);
    }

    @Override
    public QueryCondition contains(String substring) {
        return isLike("%" + substring + "%");
    }

    @Override
    public QueryCondition isIn(Collection<?> values) {
        return BinaryOperatorCondition.create(this, "IN", ListLiteralReference.create(values));
    }

    @Override
    public QueryCondition isNotIn(Collection<?> values) {
        return BinaryOperatorCondition.create(this, "NOT IN", ListLiteralReference.create(values));
    }

    public static NamedColumnImpl create(String columnName) {
        NamedColumnImpl named = new NamedColumnImpl();
        named.columnName = columnName;
        return named;
    }

    @Override
    public ColumnReferenceModel parseModel() {
        return ColumnReference.create(columnName).parseModel();
    }
}
