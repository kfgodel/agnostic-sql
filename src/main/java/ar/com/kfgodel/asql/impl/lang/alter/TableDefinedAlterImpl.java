package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.AddColumnStatement;
import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.create.ColumnDeclaration;

/**
 * Created by kfgodel on 14/07/15.
 */
public class TableDefinedAlterImpl implements TableDefinedAlter {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public static TableDefinedAlterImpl create(String tableName) {
        TableDefinedAlterImpl alter = new TableDefinedAlterImpl();
        alter.tableName = tableName;
        return alter;
    }

    @Override
    public AddColumnStatement adding(ColumnDeclaration newColumnDeclaration) {
        return AddColumnStatementImpl.create(this, newColumnDeclaration);
    }
}
