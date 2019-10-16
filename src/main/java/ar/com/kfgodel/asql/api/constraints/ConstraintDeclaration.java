package ar.com.kfgodel.asql.api.constraints;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface ConstraintDeclaration extends AgnosticConstruct {

  @Override
  ConstraintDeclarationModel parseModel();
}
