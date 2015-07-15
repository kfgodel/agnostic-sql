package ar.com.kfgodel.asql.api.delete;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;

/**
 * This type represents an agnostic delete statemente
 * Created by kfgodel on 15/07/15.
 */
public interface DeleteStatement extends AgnosticStatement {

    @Override
    DeleteModel parseModel();
}
