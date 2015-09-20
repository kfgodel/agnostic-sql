package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * Created by tenpines on 19/09/15.
 */
public class SymbolReference implements AgnosticConstruct {

    private String symbolTemplatePath;

    @Override
    public AgnosticModel parseModel() {
        return SymbolModel.create(symbolTemplatePath);
    }

    public static SymbolReference create(String symbolPath){
        SymbolReference reference = new SymbolReference();
        reference.symbolTemplatePath = symbolPath;
        return reference;
    }

}
