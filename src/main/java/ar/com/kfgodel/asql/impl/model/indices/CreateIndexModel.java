package ar.com.kfgodel.asql.impl.model.indices;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.IndexReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

import java.util.List;

/**
 * This type represents the model of an index creation
 *
 * Created by tenpines on 27/09/15.
 */
public class CreateIndexModel implements AgnosticModel {

    private IndexReferenceModel index;
    private TableReferenceModel table;
    private List<ColumnReferenceModel> columns;

    public IndexReferenceModel getIndex() {
        return index;
    }

    public TableReferenceModel getTable() {
        return table;
    }

    public List<ColumnReferenceModel> getColumns() {
        return columns;
    }

    @Override
    public String getTemplatePath() {
        return "/indices/create_index.ftl";
    }
    
    public static CreateIndexModel create(IndexReferenceModel index, TableReferenceModel table, List<ColumnReferenceModel> columns){
        CreateIndexModel indexModel = new CreateIndexModel();
        indexModel.index = index;
        indexModel.table = table;
        indexModel.columns = columns;
        return indexModel;
    }
    
}
