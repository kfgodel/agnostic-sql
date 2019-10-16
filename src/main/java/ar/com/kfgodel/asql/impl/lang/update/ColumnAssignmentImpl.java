package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;

/**
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentImpl implements ColumnAssignment {

  private ColumnReference column;
  private AgnosticConstruct columnValue;

  @Override
  public ColumnAssignmentModel parseModel() {
    return ColumnAssignmentModel.create(column.parseModel(), columnValue.parseModel());
  }

  @Override
  public AgnosticConstruct getValue() {
    return columnValue;
  }

  @Override
  public ColumnReference getColumn() {
    return column;
  }

  public static ColumnAssignmentImpl create(ColumnReference column, AgnosticConstruct columnValue) {
    ColumnAssignmentImpl assignment = new ColumnAssignmentImpl();
    assignment.column = column;
    assignment.columnValue = columnValue;
    return assignment;
  }

}
