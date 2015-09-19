package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.operands.ParseableOperand;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;

/**
 * This type represents an agnostic sql piece representing a literal reference, like a number or a string
 * Created by tenpines on 14/09/15.
 */
public class LiteralReference implements ParseableOperand, AgnosticConstruct {

    private Object value;

    @Override
    public ExplicitValueModel parseModel() {
        return ExplicitValueModel.create(value);
    }

    public static LiteralReference create(Object value){
        LiteralReference literalReference = new LiteralReference();
        literalReference.value = value;
        return literalReference;
    }

}
