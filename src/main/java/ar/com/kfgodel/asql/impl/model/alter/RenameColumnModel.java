package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

/**
 * This type represents the model of rename statement
 * Created by tenpines on 27/09/15.
 */
public class RenameColumnModel implements AgnosticModel {

    private TableReferenceModel table;
    private ColumnReferenceModel renamedColumn;
    private String newName;

    public TableReferenceModel getTable() {
        return table;
    }

    public ColumnReferenceModel getRenamedColumn() {
        return renamedColumn;
    }

    public String getNewName() {
        return newName;
    }

    @Override
    public String getTemplatePath() {
        return "/alter/rename_column.ftl";
    }
    
    public static RenameColumnModel create(TableReferenceModel table, ColumnReferenceModel column, String newName){
        RenameColumnModel model = new RenameColumnModel();
        model.table = table;
        model.renamedColumn = column;
        model.newName = newName;
        return model;
    }
    
}
