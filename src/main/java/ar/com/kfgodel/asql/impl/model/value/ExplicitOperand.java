package ar.com.kfgodel.asql.impl.model.value;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents a value that is defined explicitly in the query and which the templates may need to interact with
 * Created by kfgodel on 12/07/15.
 */
public interface ExplicitOperand extends AgnosticModel {

    Object getValue();
}
