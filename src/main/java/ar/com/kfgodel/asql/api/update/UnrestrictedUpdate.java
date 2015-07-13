package ar.com.kfgodel.asql.api.update;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface UnrestrictedUpdate extends AgnosticStatement {

    RestrictedUpdate where(QueryCondition condition);

    @Override
    UpdateModel parseModel();
}
