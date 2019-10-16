package ar.com.kfgodel.asql.impl.model.functions;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * Created by tenpines on 27/09/15.
 */
public class MonoArgInvocationModel implements AgnosticModel {

  private String functionName;
  private AgnosticModel value;

  public AgnosticModel getValue() {
    return value;
  }

  @Override
  public String getTemplatePath() {
    return "/functions/" + functionName + ".ftl";
  }

  public static MonoArgInvocationModel create(String functionName, AgnosticModel value) {
    MonoArgInvocationModel invocation = new MonoArgInvocationModel();
    invocation.functionName = functionName;
    invocation.value = value;
    return invocation;
  }

}
