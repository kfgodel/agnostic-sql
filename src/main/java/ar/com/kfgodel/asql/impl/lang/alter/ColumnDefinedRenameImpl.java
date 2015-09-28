package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.ColumnDefinedRename;
import ar.com.kfgodel.asql.api.alter.RenameColumnStatement;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;

/**
 * Created by tenpines on 27/09/15.
 */
public class ColumnDefinedRenameImpl implements ColumnDefinedRename {

    private TableDefinedAlterImpl previousNode;
    private NamedColumn renamedColumn;

    @Override
    public RenameColumnStatement to(String newName) {
        return RenameColumnStatementImpl.create(this, newName);
    }

    public static ColumnDefinedRenameImpl create(TableDefinedAlterImpl previousNode, NamedColumn renamedColumn){
        ColumnDefinedRenameImpl rename = new ColumnDefinedRenameImpl();
        rename.previousNode = previousNode;
        rename.renamedColumn = renamedColumn;
        return rename;
    }

    public TableReference getTable(){
        return previousNode.getTable();
    }

    public ColumnReference getRenamedColumn(){
        return renamedColumn.getColumn();
    }


}
