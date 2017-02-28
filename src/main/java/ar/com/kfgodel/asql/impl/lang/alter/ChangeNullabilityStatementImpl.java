package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.ChangeNullabilityStatement;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.nullability.NullabilityConstraint;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.alter.ChangeNullabilityModel;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.columns.ColumnNullabilityChangeModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

/**
 * Created by dario.garcia on 28/02/17.
 */
public class ChangeNullabilityStatementImpl implements ChangeNullabilityStatement {

  private TableDefinedAlterImpl previousNode;
  private ColumnDeclaration columnDeclaration;
  private NullabilityConstraint nullability;

  @Override
  public AgnosticModel parseModel() {
    ColumnDeclarationModel columnModel = columnDeclaration.parseModel();
    NullabilityModel nullabilityModel = nullability.parseModel();
    ColumnNullabilityChangeModel nullabilityChange = ColumnNullabilityChangeModel.create(columnModel.getColumn(), columnModel.getColumnType(), nullabilityModel);

    TableReferenceModel tableModel = previousNode.getTable().parseModel();
    return ChangeNullabilityModel.create(tableModel, nullabilityChange);
  }

  public static ChangeNullabilityStatementImpl create(TableDefinedAlterImpl previousNode, ColumnDeclaration columnDeclaration, NullabilityConstraint nullabilityConstraint) {
    ChangeNullabilityStatementImpl change = new ChangeNullabilityStatementImpl();
    change.previousNode = previousNode;
    change.columnDeclaration = columnDeclaration;
    change.nullability = nullabilityConstraint;
    return change;
  }

}
