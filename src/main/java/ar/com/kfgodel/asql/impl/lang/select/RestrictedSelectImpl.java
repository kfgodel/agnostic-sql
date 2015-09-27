package ar.com.kfgodel.asql.impl.lang.select;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.select.RestrictedSelect;
import ar.com.kfgodel.asql.impl.model.select.SelectModel;

/**
 * Created by tenpines on 27/09/15.
 */
public class RestrictedSelectImpl implements RestrictedSelect {

    private TableDefinedSelectImpl previousNode;
    private AgnosticConstruct condition;

    @Override
    public SelectModel parseModel() {
        SelectModel selectModel = previousNode.parseModel();
        selectModel.getWhereClause().setPredicate(condition.parseModel());
        return selectModel;
    }
    
    public static RestrictedSelectImpl create(TableDefinedSelectImpl previousNode, AgnosticConstruct condition){
        RestrictedSelectImpl select = new RestrictedSelectImpl();
        select.previousNode = previousNode;
        select.condition = condition;
        return select;
    }
    
}
