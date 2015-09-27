package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.insert.ColumnDefinedInsert;
import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.api.insert.TableDefinedInsert;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;

import java.util.Arrays;

/**
 * Created by kfgodel on 16/07/15.
 */
public class TableDefinedInsertImpl extends TableCenteredStatement implements TableDefinedInsert {

    @Override
    public InsertStatement setting(ColumnAssignment... columnAssignments) {
        return InsertWithColumnAssignments.create(this, Arrays.asList(columnAssignments));
    }

    @Override
    public ColumnDefinedInsert set(String... columnNames) {
        return ColumnDefinedInsertImpl.create(this, Internal.columns(columnNames));
    }

    public static TableDefinedInsertImpl create(TableReference table) {
        TableDefinedInsertImpl insert = new TableDefinedInsertImpl();
        insert.setTable(table);
        return insert;
    }

}
