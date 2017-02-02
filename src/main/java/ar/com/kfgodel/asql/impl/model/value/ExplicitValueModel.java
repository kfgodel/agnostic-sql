package ar.com.kfgodel.asql.impl.model.value;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents an explicit value that can be represented directly on the template
 * Created by kfgodel on 12/07/15.
 */
public class ExplicitValueModel implements AgnosticModel {
    private Object value;

    public Object getValue() {
        return value;
    }

    public static ExplicitValueModel create(Object value) {
        ExplicitValueModel directValue = new ExplicitValueModel();
        directValue.value = value;
        return directValue;
    }

    @Override
    public String getTemplatePath() {
        if(value instanceof String){
            return "/operands/_text.ftl";
        }
        return "/operands/_value.ftl";
    }
}
