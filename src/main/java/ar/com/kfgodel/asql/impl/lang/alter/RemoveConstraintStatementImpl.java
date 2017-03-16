package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.RemoveConstraintStatement;
import ar.com.kfgodel.asql.impl.lang.references.ConstraintReference;
import ar.com.kfgodel.asql.impl.model.alter.RemoveConstraintModel;

/**
 * Created by dario.garcia on 16/03/17.
 */
public class RemoveConstraintStatementImpl implements RemoveConstraintStatement {

  private TableDefinedAlterImpl previousNode;
  private ConstraintReference constraint;

  @Override
  public RemoveConstraintModel parseModel() {
    return RemoveConstraintModel.create(previousNode.getTable().parseModel(), constraint.parseModel());
  }


  public static RemoveConstraintStatementImpl create(TableDefinedAlterImpl previous, ConstraintReference constraint) {
    RemoveConstraintStatementImpl statement = new RemoveConstraintStatementImpl();
    statement.previousNode = previous;
    statement.constraint = constraint;
    return statement;
  }


}
