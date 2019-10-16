package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.lang.references.InsertValueListReference;
import ar.com.kfgodel.asql.impl.model.insert.InsertModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This type represents an insert statement defined in pairs of assignments
 * Created by tenpines on 27/09/15.
 */
public class InsertWithColumnAssignments implements InsertStatement {

  private TableDefinedInsertImpl previousNode;
  private List<ColumnAssignment> columnAssignments;

  @Override
  public InsertModel parseModel() {
    InsertModel insertModel = InsertModel.create(previousNode.getTable().parseModel(), getValueDefinition().parseModel());
    insertModel.setColumnList(parseColumnModels());
    return insertModel;
  }

  public static InsertWithColumnAssignments create(TableDefinedInsertImpl previousNode, List<ColumnAssignment> assignments) {
    InsertWithColumnAssignments insert = new InsertWithColumnAssignments();
    insert.previousNode = previousNode;
    insert.columnAssignments = assignments;
    return insert;
  }


  private List<ColumnReferenceModel> parseColumnModels() {
    return columnAssignments
      .stream()
      .map(ColumnAssignment::getColumn)
      .map(ColumnReference::parseModel)
      .collect(Collectors.toList());
  }

  public InsertValueListReference getValueDefinition() {
    List<AgnosticConstruct> values = columnAssignments
      .stream()
      .map(ColumnAssignment::getValue)
      .collect(Collectors.toList());
    return InsertValueListReference.create(values);
  }
}
