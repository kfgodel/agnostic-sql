package ar.com.kfgodel.asql.api.select;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.lang.select.LimitedSelectStatement;
import ar.com.kfgodel.asql.impl.model.select.SelectModel;

/**
 * This type represents an agnostic sql statement
 * Created by tenpines on 23/09/15.
 */
public interface SelectStatement extends AgnosticStatement, QueryCondition {

  default AgnosticStatement limit(int limit) {
    return LimitedSelectStatement.create(this, limit);
  }

  @Override
  SelectModel parseModel();
}
