package ar.com.kfgodel.asql.impl.model.remove;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents the state of an agnostic remove column statement
 * Created by kfgodel on 15/07/15.
 */
public class RemoveColumnModel implements AgnosticModel{

    private String tableName;
    private String columnName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public static RemoveColumnModel create(String table, String column) {
        RemoveColumnModel model = new RemoveColumnModel();
        model.tableName = table;
        model.columnName = column;
        return model;
    }

}
