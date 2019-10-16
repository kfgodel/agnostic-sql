package ar.com.kfgodel.asql.impl.model.constraints;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.create.TablePartModel;
import ar.com.kfgodel.asql.impl.model.references.ConstraintReferenceModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class ConstraintDeclarationModel implements AgnosticModel, TablePartModel {

  private ConstraintReferenceModel identification;
  private ConstraintDefinitionModel definition;

  public ConstraintReferenceModel getIdentification() {
    return identification;
  }

  public ConstraintDefinitionModel getDefinition() {
    return definition;
  }

  public static ConstraintDeclarationModel create(ConstraintDefinitionModel definition) {
    ConstraintDeclarationModel model = new ConstraintDeclarationModel();
    model.definition = definition;
    return model;
  }

  public void setIdentification(ConstraintReferenceModel identification) {
    this.identification = identification;
  }

  @Override
  public String getTemplatePath() {
    return "/constraints/_constraintDeclaration.ftl";
  }
}
