package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.api.update.ColumnAssignment;
import ar.com.kfgodel.asql.api.update.RestrictedUpdate;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.tree.UpdateNode;

import java.util.List;

/**
 * Created by kfgodel on 12/07/15.
 */
public class UnrestrictedUpdateImpl implements UnrestrictedUpdate {

    private TableDefinedUpdateImpl tableUpdate;
    private List<ColumnAssignment> assignments;

    @Override
    public RestrictedUpdate where(QueryCondition condition) {
        return RestrictedUpdateImpl.create(this, condition);
    }

    @Override
    public UpdateNode getRepresentationNode() {
        UpdateNode updateNode = tableUpdate.getRepresentationNode();
        for (ColumnAssignment columnAssignment : assignments) {
            updateNode.addAssignment(columnAssignment.getRepresentationNode());
        }
        return updateNode;
    }

    public static UnrestrictedUpdateImpl create(TableDefinedUpdateImpl tableUpdate, List<ColumnAssignment> assignments) {
        UnrestrictedUpdateImpl unconditionedUpdate = new UnrestrictedUpdateImpl();
        unconditionedUpdate.tableUpdate = tableUpdate;
        unconditionedUpdate.assignments = assignments;
        return unconditionedUpdate;
    }

}
