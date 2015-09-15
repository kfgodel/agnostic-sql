package ar.com.kfgodel.asql.api.functions;

import ar.com.kfgodel.asql.impl.lang.functions.NoArgFunctionInvocation;

/**
 * This type represents an agnostic sql function
 * Created by kfgodel on 16/07/15.
 */
public interface Function {

    static FunctionInvocation currentDate() {
        return NoArgFunctionInvocation.create("current_date");
    }

    static FunctionInvocation currentTime() {
        return NoArgFunctionInvocation.create("current_time");
    }
}
