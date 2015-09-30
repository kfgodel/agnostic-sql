package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

/**
 * Created by tenpines on 29/09/15.
 */
public class RenameTableModel implements AgnosticModel {

    private TableReferenceModel table;
    private String newName;

    public TableReferenceModel getTable() {
        return table;
    }

    public String getNewName() {
        return newName;
    }

    @Override
    public String getTemplatePath() {
        return "/alter/rename_table.ftl";
    }
    
    public static RenameTableModel create(TableReferenceModel table, String newName){
        RenameTableModel model = new RenameTableModel();
        model.table = table;
        model.newName = newName;
        return model;
    }
    
}
