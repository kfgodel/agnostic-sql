package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * This type represents the model of a symbol literal
 * Created by tenpines on 14/09/15.
 */
public class SymbolModel implements ExplicitOperand {


    private String templatePath;

    @Override
    public String getTemplatePath() {
        return templatePath;
    }
    
    public static SymbolModel create(String templatePath){
        SymbolModel symbolModel = new SymbolModel();
        symbolModel.templatePath = templatePath;
        return symbolModel;
    }

    @Override
    public Object getValue() {
        throw new UnsupportedOperationException("Symbol["+ templatePath+"] doesn't have a value");
    }
}