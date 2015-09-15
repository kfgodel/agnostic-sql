package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.impl.lang.Parseable;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;

/**
 * This type represents an agnostic sql piece representing a literal reference, like a number or a string
 * Created by tenpines on 14/09/15.
 */
public class LiteralReference implements Parseable {

    private Object value;

    @Override
    public AgnosticModel parseModel() {
        return ExplicitValueModel.create(value);
    }

    public static LiteralReference create(Object value){
        LiteralReference literalReference = new LiteralReference();
        literalReference.value = value;
        return literalReference;
    }

}
