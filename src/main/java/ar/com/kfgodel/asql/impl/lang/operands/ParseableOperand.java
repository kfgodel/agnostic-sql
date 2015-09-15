package ar.com.kfgodel.asql.impl.lang.operands;

import ar.com.kfgodel.asql.impl.lang.Parseable;
import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * This type represents an agnostic sql piece defining an operand
 * Created by tenpines on 14/09/15.
 */
public interface ParseableOperand extends Parseable {

    @Override
    ExplicitOperand parseModel();
}
