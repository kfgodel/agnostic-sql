package ar.com.kfgodel.asql.impl.model.columns;

import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.create.TablePartModel;

/**
 * This type represents the abstract model of a column declaration
 * Created by kfgodel on 13/07/15.
 */
public class ColumnDeclarationModel implements TablePartModel, AgnosticModel{

    private String columnName;
    private DataType columnType;
    private String nullity;
    private Object defaultValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public DataType getColumnType() {
        return columnType;
    }

    public void setColumnType(DataType columnType) {
        this.columnType = columnType;
    }

    public String getNullity() {
        return nullity;
    }

    public void setNullity(String nullity) {
        this.nullity = nullity;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public static ColumnDeclarationModel create(String columnName, DataType columnType) {
        ColumnDeclarationModel model = new ColumnDeclarationModel();
        model.columnName = columnName;
        model.columnType = columnType;
        return model;
    }

    public ColumnDeclarationModel withNullity(String nullity){
        this.setNullity(nullity);
        return this;
    }

    public ColumnDeclarationModel withDefaultValue(Object defaultValue){
        this.setDefaultValue(defaultValue);
        return this;
    }

    @Override
    public boolean isColumnDeclaration() {
        return true;
    }

    @Override
    public String getTemplatePath() {
        return "/columns/_columnDeclaration.ftl";
    }
}
