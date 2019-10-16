package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.nullability.NullabilityConstraint;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * This type represents the language reference to null
 * Created by tenpines on 19/09/15.
 */
public class NullReference implements AgnosticConstruct, NullabilityConstraint {

  @Override
  public NullabilityModel parseModel() {
    return SymbolModel.create("/references/_null.ftl");
  }

  public static NullReference create() {
    NullReference reference = new NullReference();
    return reference;
  }
}
