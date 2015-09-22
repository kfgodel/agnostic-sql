package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * This type represents the state of an agnostic remove column statement
 * Created by kfgodel on 15/07/15.
 */
public class RemoveColumnModel extends TableCenteredModel{

    private ColumnReferenceModel column;

    public ColumnReferenceModel getColumn() {
        return column;
    }

    public void setColumnName(ColumnReferenceModel column) {
        this.column = column;
    }

    public static RemoveColumnModel create(TableReferenceModel table, ColumnReferenceModel column) {
        RemoveColumnModel model = new RemoveColumnModel();
        model.setTable(table);
        model.column = column;
        return model;
    }

    @Override
    public String getTemplatePath() {
        return "/alter/remove_column.ftl";
    }
}
