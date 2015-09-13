package ar.com.kfgodel.asql.impl.model.constraints;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.create.TablePartModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kfgodel on 16/07/15.
 */
public class ConstraintDeclarationModel implements AgnosticModel, TablePartModel {

    private String typeName;
    private List<String> columnNames;
    private String tail;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getColumnNames() {
        if (columnNames == null) {
            columnNames = new ArrayList<String>();
        }
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }


    public static ConstraintDeclarationModel create(String typeName) {
        ConstraintDeclarationModel model = new ConstraintDeclarationModel();
        model.typeName = typeName;
        return model;
    }

    public void addColumnName(String columnName){
        this.getColumnNames().add(columnName);
    }

    public ConstraintDeclarationModel forColumns(String... columnNames){
        for (String columnName : columnNames) {
            this.addColumnName(columnName);
        }
        return this;
    }

    @Override
    public boolean isColumnDeclaration() {
        return false;
    }

    @Override
    public String getTemplatePath() {
        return "constraints/_contraintDeclaration.ftl";
    }
}
