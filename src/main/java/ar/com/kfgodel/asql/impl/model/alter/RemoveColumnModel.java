package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * This type represents the state of an agnostic remove column statement
 * Created by kfgodel on 15/07/15.
 */
public class RemoveColumnModel extends TableCenteredModel{

    private String columnName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public static RemoveColumnModel create(String table, String column) {
        RemoveColumnModel model = new RemoveColumnModel();
        model.setTableName(table);
        model.columnName = column;
        return model;
    }

    @Override
    public String getTemplatePath() {
        return "/alter/remove_column.ftl";
    }
}
