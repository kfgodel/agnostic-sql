package ar.com.kfgodel.asql.impl.lang.transactions;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * Created by tenpines on 27/09/15.
 */
public class BeginTransaction implements AgnosticStatement {
  @Override
  public AgnosticModel parseModel() {
    return SymbolModel.create("/transactions/begin.ftl");
  }

  public static BeginTransaction create() {
    BeginTransaction beginTransaction = new BeginTransaction();
    return beginTransaction;
  }

}
