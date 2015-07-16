package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.alter.ChangeColumnModel;

/**
 * This type represents an agnostic column change statement
 * Created by kfgodel on 15/07/15.
 */
public interface ChangeColumnStatement extends AgnosticStatement {

    @Override
    ChangeColumnModel parseModel();
}
