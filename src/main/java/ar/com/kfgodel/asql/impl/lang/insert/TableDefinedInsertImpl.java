package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.api.insert.TableDefinedInsert;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;

import java.util.Arrays;

/**
 * Created by kfgodel on 16/07/15.
 */
public class TableDefinedInsertImpl extends TableCenteredStatement implements TableDefinedInsert {

    @Override
    public InsertStatement setting(ColumnAssignment... columnAssignments) {
        return InsertStatementImpl.create(this, Arrays.asList(columnAssignments));
    }

    public static TableDefinedInsertImpl create(String tableName) {
        TableDefinedInsertImpl insert = new TableDefinedInsertImpl();
        insert.setTableName(tableName);
        return insert;
    }

}
