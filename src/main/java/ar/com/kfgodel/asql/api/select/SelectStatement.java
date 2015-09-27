package ar.com.kfgodel.asql.api.select;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;

/**
 * This type represents an agnostic sql statement
 * Created by tenpines on 23/09/15.
 */
public interface SelectStatement extends AgnosticStatement, QueryCondition {
}
