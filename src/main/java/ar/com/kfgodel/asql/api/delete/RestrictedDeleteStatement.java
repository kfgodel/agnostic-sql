package ar.com.kfgodel.asql.api.delete;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface RestrictedDeleteStatement extends AgnosticStatement {

    @Override
    DeleteModel parseModel();
}
