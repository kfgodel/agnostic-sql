package ar.com.kfgodel.asql.impl.lang.select;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.AsqlException;
import ar.com.kfgodel.asql.api.select.SelectStatement;
import ar.com.kfgodel.asql.impl.model.select.SelectModel;

public class LimitedSelectStatement implements SelectStatement {

  private SelectStatement previousNode;
  private int limit;

  LimitedSelectStatement(SelectStatement previousNode, int limit) {
    this.previousNode = previousNode;
    this.limit = limit;
  }

  public static LimitedSelectStatement create(SelectStatement selectStatement, int limit) {
    return new LimitedSelectStatement(selectStatement, limit);
  }

  @Override
  public AgnosticStatement limit(int limit) {
    throw new AsqlException("Limit can't be set to["+limit+"] because previous value was already set: " + limit);
  }

  @Override
  public SelectModel parseModel() {
    SelectModel selectModel = previousNode.parseModel();
    selectModel.setLimit(limit);
    return selectModel;
  }
}
