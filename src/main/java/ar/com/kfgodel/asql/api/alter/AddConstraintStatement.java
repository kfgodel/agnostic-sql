package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.alter.AddConstraintModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface AddConstraintStatement extends AgnosticStatement {

  @Override
  AddConstraintModel parseModel();
}
