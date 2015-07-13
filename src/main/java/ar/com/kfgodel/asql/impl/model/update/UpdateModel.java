package ar.com.kfgodel.asql.impl.model.update;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.where.PredicateModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This type represents a tree node for an update statement containing its state
 * Created by kfgodel on 12/07/15.
 */
public class UpdateModel implements AgnosticModel {

    private String tableName;

    private List<ColumnAssignmentModel> columnAssignments;

    private PredicateModel wherePredicate;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnAssignmentModel> getColumnAssignments() {
        if (columnAssignments == null) {
            columnAssignments = new ArrayList<ColumnAssignmentModel>();
        }
        return columnAssignments;
    }

    public void setColumnAssignments(List<ColumnAssignmentModel> columnAssignments) {
        this.columnAssignments = columnAssignments;
    }

    public PredicateModel getWherePredicate() {
        return wherePredicate;
    }

    public void setWherePredicate(PredicateModel wherePredicate) {
        this.wherePredicate = wherePredicate;
    }

    public static UpdateModel create(String tableName) {
        UpdateModel updateModel = new UpdateModel();
        updateModel.tableName = tableName;
        return updateModel;
    }

    public void addAssignment(ColumnAssignmentModel assignmentNode) {
        getColumnAssignments().add(assignmentNode);
    }
}
