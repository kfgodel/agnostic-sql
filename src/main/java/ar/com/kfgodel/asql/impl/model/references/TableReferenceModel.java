package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents the model needed to represent a table reference
 * Created by tenpines on 21/09/15.
 */
public class TableReferenceModel implements AgnosticModel {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    @Override
    public String getTemplatePath() {
        return "/references/_table.ftl";
    }
    
    public static TableReferenceModel create(String tableName){
        TableReferenceModel model = new TableReferenceModel();
        model.tableName = tableName;
        return model;
    }
    
}
