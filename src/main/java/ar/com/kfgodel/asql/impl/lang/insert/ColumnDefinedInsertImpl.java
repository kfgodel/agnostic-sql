package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.insert.ColumnDefinedInsert;
import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kfgodel on 16/07/15.
 */
public class ColumnDefinedInsertImpl implements ColumnDefinedInsert {

    private TableDefinedInsertImpl previousNode;
    private List<ColumnReference> columns;

    @Override
    public InsertStatement to(Object... values) {
        List<Object> columnValues = Arrays.asList(values);
        int columnCount = columns.size();
        if(columnCount != columnValues.size()){
            throw new IllegalArgumentException("The column and value count don't match: " + columns + " " + columnValues);
        }
        List<ColumnAssignment> columnAssignments = new ArrayList<>(columnCount);
        for (int i = 0; i < columnCount; i++) {
            ColumnReference column = columns.get(i);
            Object columnValue = columnValues.get(i);
            columnAssignments.add(Internal.columnAssignment(column, columnValue));
        }
        return InsertStatementImpl.create(previousNode, columnAssignments);
    }

    public static ColumnDefinedInsertImpl create(TableDefinedInsertImpl previousNode, List<ColumnReference> columns) {
        ColumnDefinedInsertImpl insert = new ColumnDefinedInsertImpl();
        insert.previousNode = previousNode;
        insert.columns = columns;
        return insert;
    }

}
