package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.RemoveColumnStatement;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.alter.RemoveColumnModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class RemoveColumnStatementImpl implements RemoveColumnStatement {

    private TableDefinedAlterImpl previousNode;
    private ColumnReference column;

    @Override
    public RemoveColumnModel parseModel() {
        return RemoveColumnModel.create(previousNode.getTable().parseModel(), column.parseModel());
    }

    public static RemoveColumnStatementImpl create(TableDefinedAlterImpl previous, ColumnReference column) {
        RemoveColumnStatementImpl statement = new RemoveColumnStatementImpl();
        statement.previousNode = previous;
        statement.column = column;
        return statement;
    }

}
