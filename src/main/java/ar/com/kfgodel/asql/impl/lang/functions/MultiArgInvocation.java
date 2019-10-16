package ar.com.kfgodel.asql.impl.lang.functions;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.functions.FunctionInvocation;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.functions.MultiArgInvocationModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tenpines on 27/09/15.
 */
public class MultiArgInvocation implements FunctionInvocation {

  private String functionName;
  private List<AgnosticConstruct> values;

  @Override
  public AgnosticModel parseModel() {
    return MultiArgInvocationModel.create(functionName, parseValueModels());
  }

  private List<AgnosticModel> parseValueModels() {
    return values.stream()
      .map(AgnosticConstruct::parseModel)
      .collect(Collectors.toList());
  }

  public static MultiArgInvocation create(String functionName, List<AgnosticConstruct> values) {
    MultiArgInvocation invocation = new MultiArgInvocation();
    invocation.functionName = functionName;
    invocation.values = values;
    return invocation;
  }

}
