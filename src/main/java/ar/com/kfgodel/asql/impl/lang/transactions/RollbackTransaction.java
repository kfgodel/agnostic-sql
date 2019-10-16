package ar.com.kfgodel.asql.impl.lang.transactions;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * Created by tenpines on 27/09/15.
 */
public class RollbackTransaction implements AgnosticStatement {
  @Override
  public AgnosticModel parseModel() {
    return SymbolModel.create("/transactions/rollback.ftl");
  }

  public static RollbackTransaction create() {
    RollbackTransaction rollbackTransaction = new RollbackTransaction();
    return rollbackTransaction;
  }

}
