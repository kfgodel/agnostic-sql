package ar.com.kfgodel.asql.impl.model.add;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.create.ColumnDeclarationModel;

/**
 * This type represents the agnostic model of a column addition
 * Created by kfgodel on 14/07/15.
 */
public class AddColumnModel implements AgnosticModel {

    private String tableName;

    private ColumnDeclarationModel columnDeclaration;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ColumnDeclarationModel getColumnDeclaration() {
        return columnDeclaration;
    }

    public void setColumnDeclaration(ColumnDeclarationModel columnDeclaration) {
        this.columnDeclaration = columnDeclaration;
    }

    public static AddColumnModel create(String tableName, ColumnDeclarationModel columnDeclaration) {
        AddColumnModel model = new AddColumnModel();
        model.tableName = tableName;
        model.columnDeclaration = columnDeclaration;
        return model;
    }

}
