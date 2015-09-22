package ar.com.kfgodel.asql.impl.lang;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.impl.lang.internal.PatternHelper;
import ar.com.kfgodel.asql.impl.lang.internal.impl.PatternHelperImpl;
import ar.com.kfgodel.asql.impl.lang.references.*;
import ar.com.kfgodel.asql.impl.lang.restrictions.BinaryOperatorCondition;
import ar.com.kfgodel.asql.impl.lang.update.ColumnAssignmentImpl;

import java.util.Collection;

/**
 * This interface serves as an access point to internal API objects
 * without exposing the concrete class providing the implementation
 * Created by tenpines on 21/09/15.
 */
public interface Internal {

    static PatternHelper pattern() {
        return PatternHelperImpl.create();
    }

    static ColumnReference column(String aColumnName) {
        return ColumnReference.create(aColumnName);
    }

    static LiteralReference literal(Object value) {
        return LiteralReference.create(value);
    }

    static NullReference nullRef() {
        return NullReference.create();
    }

    static ListLiteralReference list(Collection<?> values) {
        return ListLiteralReference.create(values);
    }

    static ColumnAssignment columnAssignment(String columnName, Object columnValue) {
        return ColumnAssignmentImpl.create(columnName, columnValue);
    }

    static BinaryOperatorCondition binaryOp(AgnosticConstruct leftOperand, AgnosticConstruct operator, AgnosticConstruct rightOperand) {
        return BinaryOperatorCondition.create(leftOperand, operator, rightOperand);
    }

    static TableReference table(String tableName) {
        return TableReference.create(tableName);
    }
}
