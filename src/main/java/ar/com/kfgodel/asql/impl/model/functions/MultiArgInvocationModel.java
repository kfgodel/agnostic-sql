package ar.com.kfgodel.asql.impl.model.functions;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

import java.util.List;

/**
 * Created by tenpines on 27/09/15.
 */
public class MultiArgInvocationModel implements AgnosticModel {

    private String functionName;
    private List<AgnosticModel> values;

    public List<AgnosticModel> getValues() {
        return values;
    }

    @Override
    public String getTemplatePath() {
        return "/functions/" +functionName + ".ftl";
    }
    
    public static MultiArgInvocationModel create(String functionName, List<AgnosticModel> values){
        MultiArgInvocationModel model = new MultiArgInvocationModel();
        model.functionName = functionName;
        model.values = values;
        return model;
    }
    
}
