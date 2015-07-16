package ar.com.kfgodel.asql.impl.model.support;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type serves as base clase for models that are centered around a table
 * Created by kfgodel on 15/07/15.
 */
public abstract class TableCenteredModel implements AgnosticModel {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
