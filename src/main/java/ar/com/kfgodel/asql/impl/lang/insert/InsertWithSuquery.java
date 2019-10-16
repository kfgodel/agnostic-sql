package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.impl.lang.references.SubqueryReference;
import ar.com.kfgodel.asql.impl.model.insert.InsertModel;

/**
 * This type represents an agnostic insert statement where values are defined as a subquery
 * Created by tenpines on 27/09/15.
 */
public class InsertWithSuquery implements InsertStatement {

  private ColumnDefinedInsertImpl previousNode;
  private SubqueryReference subquery;

  @Override
  public InsertModel parseModel() {
    InsertModel insertModel = InsertModel.create(previousNode.getTable().parseModel(), subquery.parseModel());
    insertModel.setColumnList(previousNode.getParsedColumnModels());
    return insertModel;
  }

  public static InsertWithSuquery create(ColumnDefinedInsertImpl previousNode, SubqueryReference subquery) {
    InsertWithSuquery insert = new InsertWithSuquery();
    insert.previousNode = previousNode;
    insert.subquery = subquery;
    return insert;
  }

}
