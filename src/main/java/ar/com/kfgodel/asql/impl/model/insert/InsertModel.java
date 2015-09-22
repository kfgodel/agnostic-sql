package ar.com.kfgodel.asql.impl.model.insert;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kfgodel on 16/07/15.
 */
public class InsertModel extends TableCenteredModel implements AgnosticModel {

    private List<ColumnAssignmentModel> columnAssignments;

    public List<ColumnAssignmentModel> getColumnAssignments() {
        if (columnAssignments == null) {
            columnAssignments = new ArrayList<ColumnAssignmentModel>();
        }
        return columnAssignments;
    }

    public void setColumnAssignments(List<ColumnAssignmentModel> columnAssignments) {
        this.columnAssignments = columnAssignments;
    }

    public static InsertModel create(TableReferenceModel table) {
        InsertModel model = new InsertModel();
        model.setTable(table);
        return model;
    }

    public void addAssignment(ColumnAssignmentModel newAssignment){
        this.getColumnAssignments().add(newAssignment);
    }

    @Override
    public String getTemplatePath() {
        return "/insert/insert.ftl";
    }
}
