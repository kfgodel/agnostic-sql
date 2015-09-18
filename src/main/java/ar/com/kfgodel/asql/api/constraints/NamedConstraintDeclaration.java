package ar.com.kfgodel.asql.api.constraints;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.constraints.NamedConstraintDeclarationModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface NamedConstraintDeclaration extends AgnosticConstruct {

    @Override
    NamedConstraintDeclarationModel parseModel();
}
