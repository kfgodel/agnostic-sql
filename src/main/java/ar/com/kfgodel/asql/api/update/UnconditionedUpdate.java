package ar.com.kfgodel.asql.api.update;

import ar.com.kfgodel.asql.api.AStatement;
import ar.com.kfgodel.asql.api.condition.QueryCondition;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface UnconditionedUpdate {
    AStatement where(QueryCondition condition);
}
