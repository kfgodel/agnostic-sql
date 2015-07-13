package ar.com.kfgodel.asql.impl.model.create;

/**
 * This type represents the abstract model of a column declaration
 * Created by kfgodel on 13/07/15.
 */
public class ColumnDeclarationModel {

    private String columnName;
    private String columnType;
    private String nullity;
    private Object defaultValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
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

    public static ColumnDeclarationModel create(String columnName, String columnType) {
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

}
