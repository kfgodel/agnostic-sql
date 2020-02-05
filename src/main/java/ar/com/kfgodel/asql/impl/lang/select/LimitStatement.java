package ar.com.kfgodel.asql.impl.lang.select;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.AsqlException;
import ar.com.kfgodel.asql.api.select.SelectStatement;
import ar.com.kfgodel.asql.impl.model.select.SelectModel;

public class LimitStatement implements SelectStatement {

  private SelectStatement previousNode;
  private int limit;

  LimitStatement(SelectStatement previousNode, int limit) {
    this.previousNode = previousNode;
    this.limit = limit;
  }

  public static LimitStatement create(SelectStatement selectStatement, int limit) {
    return new LimitStatement(selectStatement, limit);
  }

  @Override
  public AgnosticStatement limit(int limit) {
    throw new AsqlException("No se pueden poner dos limit en una misma consulta.");
  }

  @Override
  public SelectModel parseModel() {
    SelectModel selectModel = previousNode.parseModel();
    selectModel.setLimit(limit);
    return selectModel;
  }
}
