package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.update.ColumnAssignment;
import ar.com.kfgodel.asql.impl.tree.ColumnAssignmentNode;
import ar.com.kfgodel.asql.impl.value.ExplicitDirectOperand;

/**
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentImpl implements ColumnAssignment {

    private String columnName;
    private Object columnValue;

    @Override
    public ColumnAssignmentNode getRepresentationNode() {
        return ColumnAssignmentNode.create(columnName, ExplicitDirectOperand.create(columnValue));
    }

    public static ColumnAssignmentImpl create(String columnName, Object columnValue) {
        ColumnAssignmentImpl assignment = new ColumnAssignmentImpl();
        assignment.columnName = columnName;
        assignment.columnValue = columnValue;
        return assignment;
    }

}
