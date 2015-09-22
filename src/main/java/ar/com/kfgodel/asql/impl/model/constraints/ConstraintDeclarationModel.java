package ar.com.kfgodel.asql.impl.model.constraints;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.create.TablePartModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kfgodel on 16/07/15.
 */
public class ConstraintDeclarationModel implements AgnosticModel, TablePartModel {

    private String typeName;
    private List<ColumnReferenceModel> columns;
    private String tail;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<ColumnReferenceModel> getColumns() {
        if (columns == null) {
            columns = new ArrayList<>();
        }
        return columns;
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

    public void addColumn(ColumnReferenceModel column){
        this.getColumns().add(column);
    }

    public ConstraintDeclarationModel forColumns(ColumnReferenceModel... columns){
        for (ColumnReferenceModel column : columns) {
            this.addColumn(column);
        }
        return this;
    }

    @Override
    public boolean isColumnDeclaration() {
        return false;
    }

    @Override
    public String getTemplatePath() {
        return "/constraints/_constraintDeclaration.ftl";
    }
}
