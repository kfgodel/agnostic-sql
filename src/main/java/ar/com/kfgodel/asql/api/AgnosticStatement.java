package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.impl.lang.Parseable;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents a vendor agnostic sql statement as expressed by the user
 * Created by kfgodel on 11/07/15.
 */
public interface AgnosticStatement extends Parseable {
    /**
     * @return The information node that captures this statement configuration state
     */
    AgnosticModel parseModel();
}
