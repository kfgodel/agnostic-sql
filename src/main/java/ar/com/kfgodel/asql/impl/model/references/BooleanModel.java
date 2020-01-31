package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

public class BooleanModel implements AgnosticModel {
  private boolean value;

  private BooleanModel(boolean value) {
    this.value = value;
  }

  public static BooleanModel create(boolean value) {
    return new BooleanModel(value);
  }

  @Override
  public String getTemplatePath() {
    return "/references/_" + value + ".ftl";
  }

  public boolean isValue() {
    return value;
  }
}
