package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.RenameColumnStatement;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.alter.RenameColumnModel;

/**
 * Created by tenpines on 27/09/15.
 */
public class RenameColumnStatementImpl implements RenameColumnStatement {

    private ColumnDefinedRenameImpl previousNode;
    private String newColumnName;

    @Override
    public AgnosticModel parseModel() {
        return RenameColumnModel.create(previousNode.getTable().parseModel(), previousNode.getRenamedColumn().parseModel(), newColumnName);
    }
    
    public static RenameColumnStatementImpl create(ColumnDefinedRenameImpl previousNode, String newName){
        RenameColumnStatementImpl statement = new RenameColumnStatementImpl();
        statement.previousNode = previousNode;
        statement.newColumnName = newName;
        return statement;
    }
    
}
