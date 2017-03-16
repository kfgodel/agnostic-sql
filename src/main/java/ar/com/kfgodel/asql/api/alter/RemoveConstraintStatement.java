package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.alter.RemoveConstraintModel;

/**
 * This type represents a statement to remove a single constraint
 * Created by dario.garcia on 16/03/17.
 */
public interface RemoveConstraintStatement extends AgnosticStatement {

  @Override
  RemoveConstraintModel parseModel();
}
