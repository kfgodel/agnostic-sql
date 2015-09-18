package ar.com.kfgodel.asql.impl.model.value;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * Created by kfgodel on 12/07/15.
 */
public class NullOperand implements AgnosticConstruct, AgnosticModel {

    public Object getValue() {
        return "NULL";
    }

    public static NullOperand create() {
        NullOperand value = new NullOperand();
        return value;
    }

    @Override
    public String getTemplatePath() {
        return "/operands/_value.ftl";
    }

    @Override
    public AgnosticModel parseModel() {
        return this;
    }
}
