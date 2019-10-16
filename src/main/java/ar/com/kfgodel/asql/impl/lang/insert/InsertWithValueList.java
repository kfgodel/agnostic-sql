package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.impl.lang.references.InsertValueListReference;
import ar.com.kfgodel.asql.impl.model.insert.InsertModel;

/**
 * This type represents an insert statement where values are explicitly defined
 * Created by tenpines on 27/09/15.
 */
public class InsertWithValueList implements InsertStatement {

  private ColumnDefinedInsertImpl previousNode;
  private InsertValueListReference valueList;

  @Override
  public InsertModel parseModel() {
    InsertModel insertModel = InsertModel.create(previousNode.getTable().parseModel(), valueList.parseModel());
    insertModel.setColumnList(previousNode.getParsedColumnModels());
    return insertModel;
  }

  public static InsertWithValueList create(ColumnDefinedInsertImpl previousNode, InsertValueListReference valueList) {
    InsertWithValueList insert = new InsertWithValueList();
    insert.previousNode = previousNode;
    insert.valueList = valueList;
    return insert;
  }

}
