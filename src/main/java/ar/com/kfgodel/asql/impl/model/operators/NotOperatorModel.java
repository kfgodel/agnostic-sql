package ar.com.kfgodel.asql.impl.model.operators;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

import java.util.Objects;

/**
 * This type represents the model for a negated expresion where not literal is first
 * Created by tenpines on 19/09/15.
 */
public class NotOperatorModel implements AgnosticModel, NullabilityModel {

  private AgnosticModel negated;
  private String templatePath;

  public AgnosticModel getNegated() {
    return negated;
  }

  @Override
  public String getTemplatePath() {
    return templatePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NotOperatorModel)) {
      return false;
    }

    NotOperatorModel that = (NotOperatorModel) o;
    return Objects.equals(this.negated, that.negated) && Objects.equals(this.templatePath, that.templatePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.templatePath, this.negated);
  }


  public static NotOperatorModel createPlacedAfter(AgnosticModel negatedModel){
    return create(negatedModel, "/operators/_notAfter.ftl");
  }

  public static NotOperatorModel createPlacedBefore(AgnosticModel negatedModel){
    return create(negatedModel, "/operators/_notBefore.ftl");
  }

  private static NotOperatorModel create(AgnosticModel negatedModel, String templatePath) {
    NotOperatorModel model = new NotOperatorModel();
    model.negated = negatedModel;
    model.templatePath = templatePath;
    return model;
  }

}
