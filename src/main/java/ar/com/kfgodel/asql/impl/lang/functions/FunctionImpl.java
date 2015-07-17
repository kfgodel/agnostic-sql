package ar.com.kfgodel.asql.impl.lang.functions;

import ar.com.kfgodel.asql.api.functions.Function;

/**
 * Created by kfgodel on 16/07/15.
 */
public class FunctionImpl implements Function {

    private String agnosticName;
    private String value;

    @Override
    public boolean isString() {
        return Function.super.isString();
    }

    @Override
    public boolean isFunction() {
        return Function.super.isFunction();
    }

    @Override
    public boolean isSubquery() {
        return Function.super.isSubquery();
    }

    @Override
    public String getAgnosticName() {
        return agnosticName;
    }

    public static FunctionImpl create(String name) {
        FunctionImpl function = new FunctionImpl();
        function.agnosticName = name;
        return function;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
