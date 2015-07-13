package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.AStatement;
import ar.com.kfgodel.asql.api.update.PartialUpdateSet;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.tree.UpdateNode;
import ar.com.kfgodel.asql.impl.value.ExplicitDirectOperand;

/**
 * Created by kfgodel on 12/07/15.
 */
public class PartialUpdateSetImpl implements PartialUpdateSet, AStatement {

    private String columnName;
    private TableDefinedUpdateImpl tableUpdate;

    @Override
    public UnrestrictedUpdate to(Object value) {
        return UnrestrictedUpdateImpl.create(this, ExplicitDirectOperand.create(value));
    }

    public String getColumnName(){
        return columnName;
    }

    public static PartialUpdateSetImpl create(TableDefinedUpdateImpl tableUpdate, String columnName) {
        PartialUpdateSetImpl updateSet = new PartialUpdateSetImpl();
        updateSet.tableUpdate = tableUpdate;
        updateSet.columnName = columnName;
        return updateSet;
    }

    @Override
    public UpdateNode getRepresentationNode() {
        return tableUpdate.getRepresentationNode();
    }
}
