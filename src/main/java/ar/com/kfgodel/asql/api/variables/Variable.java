package ar.com.kfgodel.asql.api.variables;

import ar.com.kfgodel.asql.impl.lang.references.PositionVariableReference;

/**
 * This type represents the agnostic variables (that can be used on parameterized queries)
 * <p>
 * Created by dario.garcia on 02/02/17.
 */
public interface Variable {

  /**
   * @return The asql object to reference positional variables
   */
  static PositionVariableReference byPosition() {
    return PositionVariableReference.create();
  }
}
