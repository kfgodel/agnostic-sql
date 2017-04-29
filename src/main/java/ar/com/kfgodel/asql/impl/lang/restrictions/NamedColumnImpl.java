package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.column.MinimalColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.operators.Operator;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.Collection;

/**
 * Created by kfgodel on 12/07/15.
 */
public class NamedColumnImpl implements NamedColumn {

    private ColumnReference column;

    public ColumnReference getColumnReference() {
        return column;
    }

    @Override
    public QueryCondition isNull() {
        return Internal.binaryOp(this, Operator.is(), Internal.nullRef());
    }

    @Override
    public QueryCondition isNotNull() {
        return Internal.binaryOp(this, Operator.isNot(), Internal.nullRef());
    }

    @Override
    public ColumnAssignment to(Object value) {
        return Internal.columnAssignment(column, value);
    }

    @Override
    public ColumnDeclaration typed(DataType dataType) {
        return MinimalColumnDeclaration.create(this, dataType);
    }

    @Override
    public QueryCondition isEqualTo(Object operand) {
        return Internal.binaryOp(this, Operator.equal(), Internal.literal(operand));
    }

    @Override
    public QueryCondition isEqualToColumn(String aColumnName) {
        return Internal.binaryOp(this, Operator.equal(), Internal.column(aColumnName));
    }

    @Override
    public QueryCondition isNotEqualTo(Object value) {
        return Internal.binaryOp(this, Operator.different(), Internal.literal(value));
    }

    @Override
    public QueryCondition isNotEqualToColumn(String aColumnName) {
        return Internal.binaryOp(this, Operator.different(), Internal.column(aColumnName));
    }



    @Override
    public QueryCondition isLessThan(Object value) {
        return Internal.binaryOp(this, Operator.less(), Internal.literal(value));
    }

    @Override
    public QueryCondition isLessThanColumn(String aColumnName) {
        return Internal.binaryOp(this, Operator.less(), Internal.column(aColumnName));
    }

    @Override
    public QueryCondition isGreaterThan(Object value) {
        return Internal.binaryOp(this, Operator.greater(), Internal.literal(value));
    }

    @Override
    public QueryCondition isGreaterThanColumn(String aColumnName) {
        return Internal.binaryOp(this, Operator.greater(), Internal.column(aColumnName));
    }

    @Override
    public QueryCondition isLessOrEqualThan(Object value) {
        return Internal.binaryOp(this, Operator.lessOrEqual(), Internal.literal(value));
    }

    @Override
    public QueryCondition isLessThanOrEqualColumn(String aColumnName) {
        return Internal.binaryOp(this, Operator.lessOrEqual(), Internal.column(aColumnName));
    }

    @Override
    public QueryCondition isGreaterOrEqualThan(Object value) {
        return Internal.binaryOp(this, Operator.greaterOrEqual(), Internal.literal(value));
    }

    @Override
    public QueryCondition isGreaterOrEqualThanColumn(String aColumnName) {
        return Internal.binaryOp(this, Operator.greaterOrEqual(), Internal.column(aColumnName));
    }

    @Override
    public QueryCondition isLike(String pattern) {
        return Internal.binaryOp(this, Operator.like(), Internal.literal(pattern));
    }

    @Override
    public QueryCondition isNotLike(String pattern) {
        return Internal.binaryOp(this, Operator.notLike(), Internal.literal(pattern));
    }

    @Override
    public QueryCondition doesNotContain(String substring) {
        return isNotLike(Internal.pattern().contains(substring));
    }

    @Override
    public QueryCondition doesNotEndWith(String suffix) {
        return isNotLike(Internal.pattern().endsWith(suffix));
    }

    @Override
    public QueryCondition doesNotStartWith(String prefix) {
        return isNotLike(Internal.pattern().startsWith(prefix));
    }

    @Override
    public QueryCondition startsWith(String prefix) {
        return isLike(Internal.pattern().startsWith(prefix));
    }

    @Override
    public QueryCondition endsWith(String suffix) {
        return isLike(Internal.pattern().endsWith(suffix));
    }

    @Override
    public QueryCondition contains(String substring) {
        return isLike(Internal.pattern().contains(substring));
    }

    @Override
    public QueryCondition isIn(Collection<?> values) {
        return Internal.binaryOp(this, Operator.in(), Internal.list(values));
    }

    @Override
    public QueryCondition isNotIn(Collection<?> values) {
        return Internal.binaryOp(this, Operator.notIn(), Internal.list(values));
    }

    public static NamedColumnImpl create(ColumnReference column) {
        NamedColumnImpl named = new NamedColumnImpl();
        named.column = column;
        return named;
    }

    @Override
    public ColumnReferenceModel parseModel() {
        return column.parseModel();
    }
}
