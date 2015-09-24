package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.select.SelectStatement;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.select.SubqueryModel;

/**
 * This type represents a query reference in the context of another statement
 * Created by tenpines on 23/09/15.
 */
public class SubqueryReference implements AgnosticConstruct {

    private SelectStatement query;

    @Override
    public AgnosticModel parseModel() {
        return SubqueryModel.create(query.parseModel());
    }
    
    public static SubqueryReference create(SelectStatement query){
        SubqueryReference reference = new SubqueryReference();
        reference.query = query;
        return reference;
    }
    
}
