package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.RenameTableStatement;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.alter.RenameTableModel;

/**
 * Created by tenpines on 29/09/15.
 */
public class RenameTableStatementImpl implements RenameTableStatement {


  private TableDefinedAlterImpl previousNode;
  private String newName;

  @Override
  public AgnosticModel parseModel() {
    return RenameTableModel.create(previousNode.getTable().parseModel(), newName);
  }

  public static RenameTableStatementImpl create(TableDefinedAlterImpl previousNode, String newName) {
    RenameTableStatementImpl statement = new RenameTableStatementImpl();
    statement.previousNode = previousNode;
    statement.newName = newName;
    return statement;
  }

}
