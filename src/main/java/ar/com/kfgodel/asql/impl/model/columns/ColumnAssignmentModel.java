package ar.com.kfgodel.asql.impl.model.columns;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents a node in a statement tree for a columna assignment
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentModel implements AgnosticModel {

    private String columnName;
    private Object assignedValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getAssignedValue() {
        return assignedValue;
    }

    public void setAssignedValue(Object assignedValue) {
        this.assignedValue = assignedValue;
    }

    public static ColumnAssignmentModel create(String columnName, Object value) {
        ColumnAssignmentModel assignmentNode = new ColumnAssignmentModel();
        assignmentNode.columnName = columnName;
        assignmentNode.assignedValue = value;
        return assignmentNode;
    }

    @Override
    public String getTemplatePath() {
        return "columns/_columnAssignment.ftl";
    }
}
