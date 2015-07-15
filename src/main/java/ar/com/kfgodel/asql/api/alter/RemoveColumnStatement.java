package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.remove.RemoveColumnModel;

/**
 * This type represents an agnostic remove column statement
 * Created by kfgodel on 15/07/15.
 */
public interface RemoveColumnStatement extends AgnosticStatement {

    @Override
    RemoveColumnModel parseModel();
}
