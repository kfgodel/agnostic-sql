package ar.com.kfgodel.asql.api.functions;

import ar.com.kfgodel.asql.impl.lang.functions.FunctionImpl;
import ar.com.kfgodel.asql.impl.lang.operands.ParseableOperand;

/**
 * This type represents an agnostic sql function
 * Created by kfgodel on 16/07/15.
 */
public interface Function extends ParseableOperand {

    static Function currentDate() {
        return FunctionImpl.create("current_date");
    }

    static Function currentTime() {
        return FunctionImpl.create("current_time");
    }
}
