package ar.com.kfgodel.asql.impl.model.select;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

import java.util.List;

/**
 * This type represents the model of a from clause (used in selects)
 * Created by tenpines on 27/09/15.
 */
public class FromModel implements AgnosticModel {

    private List<TableReferenceModel> tableReferences;

    public List<TableReferenceModel> getTableReferences() {
        return tableReferences;
    }

    public static FromModel create(List<TableReferenceModel> tableReferences){
        FromModel model = new FromModel();
        model.tableReferences = tableReferences;
        return model;
    }

    @Override
    public String getTemplatePath() {
        return "/select/_fromClause.ftl";
    }
}
