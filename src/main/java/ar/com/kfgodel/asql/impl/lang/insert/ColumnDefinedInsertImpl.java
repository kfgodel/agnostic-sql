package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.insert.ColumnDefinedInsert;
import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.api.select.SelectStatement;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.lang.references.InsertValueListReference;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kfgodel on 16/07/15.
 */
public class ColumnDefinedInsertImpl implements ColumnDefinedInsert {

    private TableDefinedInsertImpl previousNode;
    private List<ColumnReference> columns;

    public TableReference getTable(){
        return previousNode.getTable();
    }

    @Override
    public InsertStatement to(Object... values) {
        List<Object> columnValues = Arrays.asList(values);
        int columnCount = columns.size();
        if(columnCount != columnValues.size()){
            // sanity/misuse check
            throw new IllegalArgumentException("The column and value count don't match: " + columns + " " + columnValues);
        }
        return InsertWithValueList.create(this, InsertValueListReference.create(Internal.asConstructs(values)));
    }

    @Override
    public InsertStatement to(SelectStatement subquery) {
        return InsertWithSuquery.create(this, Internal.asSubquery(subquery));
    }

    public static ColumnDefinedInsertImpl create(TableDefinedInsertImpl previousNode, List<ColumnReference> columns) {
        ColumnDefinedInsertImpl insert = new ColumnDefinedInsertImpl();
        insert.previousNode = previousNode;
        insert.columns = columns;
        return insert;
    }

    public List<ColumnReferenceModel> getParsedColumnModels() {
        return columns.stream()
                .map(ColumnReference::parseModel)
                .collect(Collectors.toList());
    }
}
