package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.AddColumnStatement;
import ar.com.kfgodel.asql.api.alter.RemoveColumnStatement;
import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;

/**
 * Created by kfgodel on 14/07/15.
 */
public class TableDefinedAlterImpl extends TableCenteredStatement implements TableDefinedAlter {

    public static TableDefinedAlterImpl create(String tableName) {
        TableDefinedAlterImpl alter = new TableDefinedAlterImpl();
        alter.setTableName(tableName);
        return alter;
    }

    @Override
    public AddColumnStatement adding(ColumnDeclaration newColumnDeclaration) {
        return AddColumnStatementImpl.create(this, newColumnDeclaration);
    }

    @Override
    public RemoveColumnStatement removing(String columnName) {
        return RemoveColumnStatementImpl.create(this, columnName);
    }
}
