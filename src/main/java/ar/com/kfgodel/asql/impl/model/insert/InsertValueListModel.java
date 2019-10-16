package ar.com.kfgodel.asql.impl.model.insert;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.value.ValueListModel;

/**
 * This type represents the model of a value list for an insert statement
 * Created by tenpines on 27/09/15.
 */
public class InsertValueListModel implements AgnosticModel {

  private ValueListModel values;

  public ValueListModel getValues() {
    return values;
  }

  public static InsertValueListModel create(ValueListModel values) {
    InsertValueListModel listModel = new InsertValueListModel();
    listModel.values = values;
    return listModel;
  }

  @Override
  public String getTemplatePath() {
    return "/insert/_valueList.ftl";
  }
}
