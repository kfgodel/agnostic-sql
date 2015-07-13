package ar.com.kfgodel.asql.impl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This type represents a tree node for an update statement containing its state
 * Created by kfgodel on 12/07/15.
 */
public class UpdateNode implements TemplateUsable {

    private String tableName;

    private List<ColumnAssignmentNode> columnAssignments;

    private PredicateNode wherePredicate;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnAssignmentNode> getColumnAssignments() {
        if (columnAssignments == null) {
            columnAssignments = new ArrayList<ColumnAssignmentNode>();
        }
        return columnAssignments;
    }

    public void setColumnAssignments(List<ColumnAssignmentNode> columnAssignments) {
        this.columnAssignments = columnAssignments;
    }

    public PredicateNode getWherePredicate() {
        return wherePredicate;
    }

    public void setWherePredicate(PredicateNode wherePredicate) {
        this.wherePredicate = wherePredicate;
    }

    public static UpdateNode create(String tableName) {
        UpdateNode updateNode = new UpdateNode();
        updateNode.tableName = tableName;
        return updateNode;
    }

    public void addAssignment(ColumnAssignmentNode assignmentNode) {
        getColumnAssignments().add(assignmentNode);
    }
}
