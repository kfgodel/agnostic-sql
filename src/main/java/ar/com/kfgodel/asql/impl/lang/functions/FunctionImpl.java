package ar.com.kfgodel.asql.impl.lang.functions;

import ar.com.kfgodel.asql.api.functions.Function;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * Created by kfgodel on 16/07/15.
 */
public class FunctionImpl implements Function {

    private String name;

    public static FunctionImpl create(String name) {
        FunctionImpl function = new FunctionImpl();
        function.name = name;
        return function;
    }

    @Override
    public ExplicitOperand parseModel() {
        return SymbolModel.create("/functions/"+name+".ftl");
    }
}
