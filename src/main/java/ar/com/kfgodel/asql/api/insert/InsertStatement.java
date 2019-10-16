package ar.com.kfgodel.asql.api.insert;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.insert.InsertModel;

/**
 * This type represents an agnostic insert statement
 * Created by kfgodel on 16/07/15.
 */
public interface InsertStatement extends AgnosticStatement {

  @Override
  InsertModel parseModel();
}
