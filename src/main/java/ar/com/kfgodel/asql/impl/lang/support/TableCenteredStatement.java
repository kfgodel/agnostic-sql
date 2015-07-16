package ar.com.kfgodel.asql.impl.lang.support;

/**
 * This type serves as a base class for statements that are centered around a table
 * Created by kfgodel on 15/07/15.
 */
public abstract class TableCenteredStatement {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
