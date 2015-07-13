package ar.com.kfgodel.asql.impl.tree;

/**
 * This type represents a node in a statement tree for a columna assignment
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentNode implements TemplateUsable {

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

    public static ColumnAssignmentNode create(String columnName, Object value) {
        ColumnAssignmentNode assignmentNode = new ColumnAssignmentNode();
        assignmentNode.columnName = columnName;
        assignmentNode.assignedValue = value;
        return assignmentNode;
    }

}
