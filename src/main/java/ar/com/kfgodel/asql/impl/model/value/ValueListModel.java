package ar.com.kfgodel.asql.impl.model.value;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

import java.util.List;

/**
 * This type represents the agnostic model for a list of values
 * Created by tenpines on 19/09/15.
 */
public class ValueListModel implements AgnosticModel {

  private List<AgnosticModel> values;

  public List<AgnosticModel> getValues() {
    return values;
  }

  @Override
  public String getTemplatePath() {
    return "/operands/_list.ftl";
  }

  public static ValueListModel create(List<AgnosticModel> values) {
    ValueListModel model = new ValueListModel();
    model.values = values;
    return model;
  }


}
