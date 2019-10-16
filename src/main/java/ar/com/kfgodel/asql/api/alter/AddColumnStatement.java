package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.alter.AddColumnModel;

/**
 * This type represents a columnd addition agnostic statement
 * Created by kfgodel on 14/07/15.
 */
public interface AddColumnStatement extends AgnosticStatement {

  @Override
  AddColumnModel parseModel();
}
