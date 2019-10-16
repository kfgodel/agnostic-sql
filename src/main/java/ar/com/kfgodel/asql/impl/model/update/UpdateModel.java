package ar.com.kfgodel.asql.impl.model.update;

import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.restrictions.WhereConstrainedModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;
import ar.com.kfgodel.asql.impl.model.where.WhereModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This type represents a tree node for an update statement containing its state
 * Created by kfgodel on 12/07/15.
 */
public class UpdateModel extends TableCenteredModel implements WhereConstrainedModel {

  private List<ColumnAssignmentModel> columnAssignments;

  private WhereModel whereClause;

  public List<ColumnAssignmentModel> getColumnAssignments() {
    if (columnAssignments == null) {
      columnAssignments = new ArrayList<ColumnAssignmentModel>();
    }
    return columnAssignments;
  }

  public void setColumnAssignments(List<ColumnAssignmentModel> columnAssignments) {
    this.columnAssignments = columnAssignments;
  }

  public static UpdateModel create(TableReferenceModel table, List<ColumnAssignmentModel> columnAssignments) {
    if (columnAssignments.isEmpty()) {
      throw new IllegalArgumentException("At least one assignment needed");
    }
    UpdateModel updateModel = new UpdateModel();
    updateModel.whereClause = WhereModel.create();
    updateModel.setTable(table);
    updateModel.setColumnAssignments(columnAssignments);
    return updateModel;
  }

  @Override
  public String getTemplatePath() {
    return "/update/update.ftl";
  }

  public WhereModel getWhereClause() {
    return whereClause;
  }

}
