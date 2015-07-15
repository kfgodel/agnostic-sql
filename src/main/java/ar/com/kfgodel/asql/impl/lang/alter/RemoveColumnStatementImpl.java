package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.RemoveColumnStatement;
import ar.com.kfgodel.asql.impl.model.alter.RemoveColumnModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class RemoveColumnStatementImpl implements RemoveColumnStatement {

    private TableDefinedAlterImpl previousNode;
    private String columnName;

    @Override
    public RemoveColumnModel parseModel() {
        return RemoveColumnModel.create(previousNode.getTableName(), columnName);
    }

    public static RemoveColumnStatementImpl create(TableDefinedAlterImpl previous, String columnName) {
        RemoveColumnStatementImpl statement = new RemoveColumnStatementImpl();
        statement.previousNode = previous;
        statement.columnName = columnName;
        return statement;
    }

}
