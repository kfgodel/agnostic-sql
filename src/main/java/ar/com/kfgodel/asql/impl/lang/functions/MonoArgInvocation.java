package ar.com.kfgodel.asql.impl.lang.functions;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.functions.FunctionInvocation;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.functions.MonoArgInvocationModel;

/**
 * This type represents the invocation of a function with a single argument
 * Created by tenpines on 27/09/15.
 */
public class MonoArgInvocation implements FunctionInvocation {

  private String functionName;
  private AgnosticConstruct value;

  @Override
  public AgnosticModel parseModel() {
    return MonoArgInvocationModel.create(functionName, value.parseModel());
  }

  public static MonoArgInvocation create(String name, AgnosticConstruct value) {
    MonoArgInvocation invocation = new MonoArgInvocation();
    invocation.functionName = name;
    invocation.value = value;
    return invocation;
  }

}
