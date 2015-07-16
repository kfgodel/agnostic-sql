package ar.com.kfgodel.asql.api.insert;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface TableDefinedInsert {

    InsertStatement setting(ColumnAssignment... columnAssignments);
}
