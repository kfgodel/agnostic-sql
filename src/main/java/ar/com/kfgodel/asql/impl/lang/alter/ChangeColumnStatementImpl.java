package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.ChangeColumnStatement;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.model.alter.ChangeColumnModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class ChangeColumnStatementImpl implements ChangeColumnStatement {

    private TableDefinedAlterImpl previousNode;
    private ColumnDeclaration column;

    @Override
    public ChangeColumnModel parseModel() {
        return ChangeColumnModel.create(previousNode.getTableName(), column.parseModel());
    }

    public static ChangeColumnStatementImpl create(TableDefinedAlterImpl previousNode, ColumnDeclaration column) {
        ChangeColumnStatementImpl statement = new ChangeColumnStatementImpl();
        statement.previousNode = previousNode;
        statement.column = column;
        return statement;
    }

}
