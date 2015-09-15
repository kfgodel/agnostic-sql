package ar.com.kfgodel.asql.impl.model.columns;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * This type represents a node in a statement tree for a columna assignment
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentModel implements AgnosticModel {

    private String columnName;
    private ExplicitOperand assignedValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ExplicitOperand getAssignedValue() {
        return assignedValue;
    }

    public void setAssignedValue(ExplicitOperand assignedValue) {
        this.assignedValue = assignedValue;
    }

    public static ColumnAssignmentModel create(String columnName, ExplicitOperand value) {
        ColumnAssignmentModel assignmentNode = new ColumnAssignmentModel();
        assignmentNode.columnName = columnName;
        assignmentNode.assignedValue = value;
        return assignmentNode;
    }

    @Override
    public String getTemplatePath() {
        return "/columns/_columnAssignment.ftl";
    }
}
