package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * This type represents the language reference for positional variables '?'
 * (Used in som parameterized jdbc queries)
 * <p>
 * Created by dario.garcia on 02/02/17.
 */
public class PositionVariableReference implements AgnosticConstruct {

  @Override
  public AgnosticModel parseModel() {
    return SymbolModel.create("/references/_positionVariable.ftl");
  }

  public static PositionVariableReference create() {
    PositionVariableReference reference = new PositionVariableReference();
    return reference;
  }

}
