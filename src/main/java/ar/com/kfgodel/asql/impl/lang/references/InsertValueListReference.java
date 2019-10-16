package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.insert.InsertValueListModel;
import ar.com.kfgodel.asql.impl.model.value.ValueListModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This type represents a list of values defined in an insert statement
 * Created by tenpines on 27/09/15.
 */
public class InsertValueListReference implements AgnosticConstruct {

  private List<AgnosticConstruct> values;

  @Override
  public AgnosticModel parseModel() {
    return InsertValueListModel.create(ValueListModel.create(parseValueModels()));
  }

  private List<AgnosticModel> parseValueModels() {
    return values.stream()
      .map(AgnosticConstruct::parseModel)
      .collect(Collectors.toList());
  }

  public static InsertValueListReference create(List<AgnosticConstruct> values) {
    InsertValueListReference listReference = new InsertValueListReference();
    listReference.values = values;
    return listReference;
  }

}
