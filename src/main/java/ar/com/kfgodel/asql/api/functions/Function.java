package ar.com.kfgodel.asql.api.functions;

import ar.com.kfgodel.asql.impl.lang.functions.FunctionImpl;
import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * This type represents an agnostic sql function
 * Created by kfgodel on 16/07/15.
 */
public interface Function extends ExplicitOperand {

    String getAgnosticName();

    @Override
    default boolean isString() {
        return false;
    }

    @Override
    default boolean isFunction() {
        return true;
    }

    @Override
    default boolean isSubquery() {
        return false;
    }

    static Function currentDate() {
        return FunctionImpl.create("current_date");
    }

    static Function currentTime() {
        return FunctionImpl.create("current_time");
    }
}
