package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.AStatement;
import ar.com.kfgodel.asql.api.update.PartialUpdateSet;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.impl.tree.UpdateNode;

/**
 * Created by kfgodel on 12/07/15.
 */
public class TableDefinedUpdateImpl implements TableDefinedUpdate, AStatement {

    private String tableName;

    public static TableDefinedUpdateImpl create(String tableName) {
        TableDefinedUpdateImpl update = new TableDefinedUpdateImpl();
        update.tableName = tableName;
        return update;
    }

    @Override
    public PartialUpdateSet set(String columnName) {
        return PartialUpdateSetImpl.create(this, columnName);
    }

    @Override
    public UpdateNode getRepresentationNode() {
        return UpdateNode.create(tableName);
    }
}
