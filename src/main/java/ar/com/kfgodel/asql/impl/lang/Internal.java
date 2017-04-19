package ar.com.kfgodel.asql.impl.lang;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.select.SelectStatement;
import ar.com.kfgodel.asql.impl.lang.internal.PatternHelper;
import ar.com.kfgodel.asql.impl.lang.internal.impl.PatternHelperImpl;
import ar.com.kfgodel.asql.impl.lang.references.*;
import ar.com.kfgodel.asql.impl.lang.restrictions.BinaryOperatorCondition;
import ar.com.kfgodel.asql.impl.lang.update.ColumnAssignmentImpl;
import ar.com.kfgodel.asql.impl.model.references.BooleanReference;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

  static SequenceReference sequence(String aSequenceName) {
    return SequenceReference.create(aSequenceName);
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

  static ColumnAssignment columnAssignment(ColumnReference column, Object columnValue) {
    return ColumnAssignmentImpl.create(column, Internal.asConstruct(columnValue));
  }

  static BinaryOperatorCondition binaryOp(AgnosticConstruct leftOperand, AgnosticConstruct operator, AgnosticConstruct rightOperand) {
    return BinaryOperatorCondition.create(leftOperand, operator, rightOperand);
  }

  static TableReference table(String tableName) {
    return TableReference.create(tableName);
  }

  static List<ColumnReference> columns(String... columnNames) {
    return Arrays.stream(columnNames)
      .map(Internal::column)
      .collect(Collectors.toList());
  }

  static ConstraintReference constraint(String constraintName) {
    return ConstraintReference.create(constraintName);
  }

  static AgnosticConstruct asConstruct(Object expression) {
    if (expression instanceof SelectStatement) {
      return SubqueryReference.create((SelectStatement) expression);
    }
    if (expression instanceof AgnosticConstruct) {
      // No need for conversion
      return (AgnosticConstruct) expression;
    }
    if (expression instanceof Boolean) {
      Boolean asBoolean = (Boolean) expression;
      return boolRef(asBoolean);
    }
    return Internal.literal(expression);
  }

  static AgnosticConstruct boolRef(boolean value) {
    return BooleanReference.create(value);
  }

  static List<AgnosticConstruct> asConstructs(Object... expressions) {
    return Arrays.stream(expressions)
      .map(Internal::asConstruct)
      .collect(Collectors.toList());
  }

  static IndexReference index(String indexName) {
    return IndexReference.create(indexName);
  }
}
