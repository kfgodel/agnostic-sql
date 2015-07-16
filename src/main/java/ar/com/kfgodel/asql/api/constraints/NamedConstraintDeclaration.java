package ar.com.kfgodel.asql.api.constraints;

import ar.com.kfgodel.asql.impl.lang.Parseable;
import ar.com.kfgodel.asql.impl.model.constraints.NamedConstraintDeclarationModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface NamedConstraintDeclaration extends Parseable {

    @Override
    NamedConstraintDeclarationModel parseModel();
}
