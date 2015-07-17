package ar.com.kfgodel.asql.api.update;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface TableDefinedUpdate {

    UnrestrictedUpdate setting(ColumnAssignment... assignments);

}
