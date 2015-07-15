package ar.com.kfgodel.asql.impl.model.create;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This type represents the abstract model of an agnostic create statement
 * Created by kfgodel on 13/07/15.
 */
public class CreateModel implements AgnosticModel {
    private String tableName;
    private List<ColumnDeclarationModel> columnDeclarations;
    private List<TableConstraintModel> tableConstraints;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnDeclarationModel> getColumnDeclarations() {
        if (columnDeclarations == null) {
            columnDeclarations = new ArrayList<ColumnDeclarationModel>();
        }
        return columnDeclarations;
    }

    public void setColumnDeclarations(List<ColumnDeclarationModel> columnDeclarations) {
        this.columnDeclarations = columnDeclarations;
    }

    public List<TableConstraintModel> getTableConstraints() {
        if (tableConstraints == null) {
            tableConstraints = new ArrayList<TableConstraintModel>();
        }
        return tableConstraints;
    }

    public void setTableConstraints(List<TableConstraintModel> tableConstraints) {
        this.tableConstraints = tableConstraints;
    }

    public static CreateModel create(String tableName) {
        CreateModel model = new CreateModel();
        model.tableName = tableName;
        return model;
    }

    public void addDeclaration(ColumnDeclarationModel declaration) {
        this.getColumnDeclarations().add(declaration);
    }

    public void addConstraint(TableConstraintModel constraint) {
        this.getTableConstraints().add(constraint);
    }

    public List<TablePartModel> getTableParts(){
        ArrayList<TablePartModel> parts = new ArrayList<>();
        parts.addAll(getColumnDeclarations());
        parts.addAll(getTableConstraints());
        return parts;
    }
}
