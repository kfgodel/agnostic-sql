package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * Created by tenpines on 19/09/15.
 */
public class OperatorReference implements AgnosticConstruct {

  private String agnosticName;

  @Override
  public AgnosticModel parseModel() {
    return SymbolModel.create("/operators/_" + agnosticName + ".ftl");
  }

  public static OperatorReference create(String name) {
    OperatorReference reference = new OperatorReference();
    reference.agnosticName = name;
    return reference;
  }

}
