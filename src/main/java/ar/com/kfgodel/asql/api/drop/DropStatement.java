package ar.com.kfgodel.asql.api.drop;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.drop.DropModel;

/**
 * This type represents an agnostic drop table statement
 * Created by kfgodel on 15/07/15.
 */
public interface DropStatement extends AgnosticStatement {

  @Override
  DropModel parseModel();
}
