package ar.com.kfgodel.asql.impl.lang.functions;

import ar.com.kfgodel.asql.api.functions.Function;

/**
 * Created by kfgodel on 16/07/15.
 */
public class FunctionImpl implements Function {

    private String templatePath;

    public static FunctionImpl create(String name) {
        FunctionImpl function = new FunctionImpl();
        function.templatePath = "/functions/"+name+".ftl";
        return function;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getTemplatePath() {
        return templatePath;
    }
}
