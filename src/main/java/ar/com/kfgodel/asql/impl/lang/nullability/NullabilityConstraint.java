package ar.com.kfgodel.asql.impl.lang.nullability;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

/**
 * This type represents a restriction on the nullability of a column type
 * Created by dario.garcia on 28/02/17.
 */
public interface NullabilityConstraint extends AgnosticConstruct {

  @Override
  NullabilityModel parseModel();
}
