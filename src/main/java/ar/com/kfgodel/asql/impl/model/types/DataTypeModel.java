package ar.com.kfgodel.asql.impl.model.types;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

import java.util.List;
import java.util.Objects;

/**
 * This type represents the model of a data type
 * Created by tenpines on 29/09/15.
 */
public class DataTypeModel implements AgnosticModel {

  private String agnosticName;
  private List<AgnosticModel> arguments;

  public String getAgnosticName() {
    return agnosticName;
  }

  public List<AgnosticModel> getArguments() {
    return arguments;
  }

  public AgnosticModel getArgument() {
    if (getArguments().size() != 1) {
      throw new IllegalStateException("This model doesn't have just one argument: " + getArguments());
    }
    return getArguments().get(0);
  }

  @Override
  public String getTemplatePath() {
    return "/types/" + agnosticName + ".ftl";
  }

  public static DataTypeModel create(String agnosticName, List<AgnosticModel> arguments) {
    DataTypeModel model = new DataTypeModel();
    model.agnosticName = agnosticName;
    model.arguments = arguments;
    return model;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.agnosticName, this.getArguments());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!DataTypeModel.class.isInstance(obj)) {
      return false;
    }
    DataTypeModel that = (DataTypeModel) obj;
    return this.agnosticName.equals(that.agnosticName) && this.getArguments().equals(that.getArguments());
  }
}
