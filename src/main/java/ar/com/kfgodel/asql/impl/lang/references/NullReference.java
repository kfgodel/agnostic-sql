package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SymbolModel;

/**
 * This type represents the language reference to null
 * Created by tenpines on 19/09/15.
 */
public class NullReference implements AgnosticConstruct {

    @Override
    public AgnosticModel parseModel() {
        return SymbolModel.create("/operands/_null.ftl");
    }
    
    public static NullReference create(){
        NullReference reference = new NullReference();
        return reference;
    }
}
