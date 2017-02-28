package ar.com.kfgodel.asql.impl.model.operators;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

import java.util.Objects;

/**
 * This type represents the model for a negated expresion where not literal is first
 * Created by tenpines on 19/09/15.
 */
public class NotPlacedBeforeModel implements AgnosticModel, NullabilityModel {

  private AgnosticModel negated;

  public AgnosticModel getNegated() {
    return negated;
  }

  @Override
  public String getTemplatePath() {
    return "/operators/_notBefore.ftl";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NotPlacedBeforeModel)) {
      return false;
    }

    NotPlacedBeforeModel that = (NotPlacedBeforeModel) o;
    return Objects.equals(this.negated, that.negated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getClass(), this.negated);
  }

  public static NotPlacedBeforeModel create(AgnosticModel negatedModel) {
    NotPlacedBeforeModel beforeModel = new NotPlacedBeforeModel();
    beforeModel.negated = negatedModel;
    return beforeModel;
  }

}
