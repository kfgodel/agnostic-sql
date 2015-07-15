package ar.com.kfgodel.asql.impl.model.delete;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents the state of an agnostic delete statement
 * Created by kfgodel on 15/07/15.
 */
public class DeleteModel implements AgnosticModel{

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public static DeleteModel create(String tableName) {
        DeleteModel model = new DeleteModel();
        model.tableName = tableName;
        return model;
    }

}
