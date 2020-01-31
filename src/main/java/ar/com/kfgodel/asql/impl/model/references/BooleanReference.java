package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents a literal reference to a boolean value
 * Created by tenpines on 23/09/15.
 */
public class BooleanReference implements QueryCondition {

  private BooleanModel value;

  @Override
  public AgnosticModel parseModel() {
//    return SymbolModel.create("/references/_" + value + ".ftl");
    return value;
  }

  public static BooleanReference create(boolean value) {
    BooleanReference reference = new BooleanReference();
    reference.value = BooleanModel.create(value);
    return reference;
  }

}
