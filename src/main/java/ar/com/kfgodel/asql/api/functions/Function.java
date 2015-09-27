package ar.com.kfgodel.asql.api.functions;

import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.impl.lang.functions.MonoArgInvocation;
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

    static FunctionInvocation count() {
        return NoArgFunctionInvocation.create("count_all");
    }

    static FunctionInvocation count(NamedColumn countedColumn) {
        return MonoArgInvocation.create("count_column", countedColumn);
    }

    static FunctionInvocation max(NamedColumn maxedColumn) {
        return MonoArgInvocation.create("max", maxedColumn);
    }
    static FunctionInvocation min(NamedColumn maxedColumn) {
        return MonoArgInvocation.create("min", maxedColumn);
    }
    static FunctionInvocation sum(NamedColumn maxedColumn) {
        return MonoArgInvocation.create("sum", maxedColumn);
    }
    static FunctionInvocation avg(NamedColumn maxedColumn) {
        return MonoArgInvocation.create("avg", maxedColumn);
    }


}
