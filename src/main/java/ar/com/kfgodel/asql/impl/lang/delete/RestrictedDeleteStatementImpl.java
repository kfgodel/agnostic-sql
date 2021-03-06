package ar.com.kfgodel.asql.impl.lang.delete;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.delete.RestrictedDeleteStatement;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class RestrictedDeleteStatementImpl implements RestrictedDeleteStatement {

  private UnrestrictedDeleteStatementImpl previousNode;
  private AgnosticConstruct condition;

  @Override
  public DeleteModel parseModel() {
    DeleteModel model = previousNode.parseModel();
    model.getWhereClause().setPredicate(condition.parseModel());
    return model;
  }

  public static RestrictedDeleteStatementImpl create(UnrestrictedDeleteStatementImpl previousNode, AgnosticConstruct condition) {
    RestrictedDeleteStatementImpl statement = new RestrictedDeleteStatementImpl();
    statement.previousNode = previousNode;
    statement.condition = condition;
    return statement;
  }

}
