package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.AStatement;
import ar.com.kfgodel.asql.api.update.ColumnAssignment;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.tree.UpdateNode;
import com.google.common.collect.Lists;

import java.util.List;

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
    public UnrestrictedUpdate set(ColumnAssignment... assignments) {
        if(assignments == null || assignments.length == 0){
            throw new IllegalArgumentException("At least one assignment needed");
        }
        List<ColumnAssignment> list = Lists.newArrayList(assignments);
        return UnrestrictedUpdateImpl.create(this, list);
    }

    @Override
    public UpdateNode getRepresentationNode() {
        return UpdateNode.create(tableName);
    }
}
