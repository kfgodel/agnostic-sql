package ar.com.kfgodel.asql.impl.lang.support;

import ar.com.kfgodel.asql.impl.lang.references.TableReference;

/**
 * This type serves as a base class for statements that are centered around a table
 * Created by kfgodel on 15/07/15.
 */
public abstract class TableCenteredStatement {

    private TableReference table;

    public TableReference getTable() {
        return table;
    }

    public void setTable(TableReference table) {
        this.table = table;
    }
}
