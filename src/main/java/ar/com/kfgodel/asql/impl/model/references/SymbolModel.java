package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

/**
 * This type represents the model of a symbol literal
 * Created by tenpines on 14/09/15.
 */
public class SymbolModel implements AgnosticModel, NullabilityModel {

    private String templatePath;

    @Override
    public String getTemplatePath() {
        return templatePath;
    }
    
    @Override
    public int hashCode() {
        return templatePath.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!SymbolModel.class.isInstance(obj)){
            return false;
        }
        SymbolModel that = SymbolModel.class.cast(obj);
        return this.templatePath.equals(that.templatePath);
    }

    public static SymbolModel create(String templatePath) {
        SymbolModel symbolModel = new SymbolModel();
        symbolModel.templatePath = templatePath;
        return symbolModel;
    }
}
