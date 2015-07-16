package ar.com.kfgodel.asql.impl.model.create;

import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This type represents the abstract model of an agnostic create statement
 * Created by kfgodel on 13/07/15.
 */
public class CreateModel extends TableCenteredModel {
    private List<ColumnDeclarationModel> columnDeclarations;
    private List<TableConstraintModel> tableConstraints;

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
        model.setTableName(tableName);
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
