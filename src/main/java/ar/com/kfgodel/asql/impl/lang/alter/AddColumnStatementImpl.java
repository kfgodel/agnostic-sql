package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.AddColumnStatement;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.model.alter.AddColumnModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class AddColumnStatementImpl implements AddColumnStatement {

    private TableDefinedAlterImpl previousNode;
    private ColumnDeclaration column;

    @Override
    public AddColumnModel parseModel() {
        return AddColumnModel.create(previousNode.getTable().parseModel(), column.parseModel());
    }

    public static AddColumnStatementImpl create(TableDefinedAlterImpl definedAlter, ColumnDeclaration columnDeclaration) {
        AddColumnStatementImpl statement = new AddColumnStatementImpl();
        statement.previousNode = definedAlter;
        statement.column = columnDeclaration;
        return statement;
    }

}
