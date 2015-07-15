package ar.com.kfgodel.asql.api.create;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public interface CreateStatement extends AgnosticStatement {

    @Override
    CreateModel parseModel();

}
