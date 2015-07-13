package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.api.update.RestrictedUpdate;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.tree.ColumnAssignmentNode;
import ar.com.kfgodel.asql.impl.tree.UpdateNode;

/**
 * Created by kfgodel on 12/07/15.
 */
public class UnrestrictedUpdateImpl implements UnrestrictedUpdate {

    private PartialUpdateSetImpl partialUpdateSet;
    private Object value;

    @Override
    public RestrictedUpdate where(QueryCondition condition) {
        return RestrictedUpdateImpl.create(this, condition);
    }

    @Override
    public UpdateNode getRepresentationNode() {
        UpdateNode updateNode = partialUpdateSet.getRepresentationNode();
        String columnName = partialUpdateSet.getColumnName();

        ColumnAssignmentNode columnAssignment = ColumnAssignmentNode.create(columnName, value);
        updateNode.addAssignment(columnAssignment);
        return updateNode;
    }

    public static UnrestrictedUpdateImpl create(PartialUpdateSetImpl partialUpdateSet, Object value) {
        UnrestrictedUpdateImpl unconditionedUpdate = new UnrestrictedUpdateImpl();
        unconditionedUpdate.partialUpdateSet = partialUpdateSet;
        unconditionedUpdate.value = value;
        return unconditionedUpdate;
    }

}
