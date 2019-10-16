package ar.com.kfgodel.asql.impl.lang.functions;

import ar.com.kfgodel.asql.api.functions.FunctionInvocation;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * Implementation of function invocations without arguments
 * Created by kfgodel on 16/07/15.
 */
public class NoArgFunctionInvocation implements FunctionInvocation {

  private String name;

  public static NoArgFunctionInvocation create(String name) {
    NoArgFunctionInvocation function = new NoArgFunctionInvocation();
    function.name = name;
    return function;
  }

  @Override
  public SymbolModel parseModel() {
    return SymbolModel.create("/functions/" + name + ".ftl");
  }
}
