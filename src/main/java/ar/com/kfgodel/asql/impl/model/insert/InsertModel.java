package ar.com.kfgodel.asql.impl.model.insert;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

import java.util.List;

/**
 * Created by kfgodel on 16/07/15.
 */
public class InsertModel extends TableCenteredModel implements AgnosticModel {

    private AgnosticModel valueDefinition;
    private List<ColumnReferenceModel> columnList;

    public boolean getHasColumnList(){
        return columnList != null;
    }

    public List<ColumnReferenceModel> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnReferenceModel> columnList) {
        this.columnList = columnList;
    }

    public AgnosticModel getValueDefinition() {
        return valueDefinition;
    }

    public static InsertModel create(TableReferenceModel table, AgnosticModel valueDefinition) {
        InsertModel model = new InsertModel();
        model.setTable(table);
        model.valueDefinition = valueDefinition;
        return model;
    }

    @Override
    public String getTemplatePath() {
        return "/insert/insert.ftl";
    }
}
