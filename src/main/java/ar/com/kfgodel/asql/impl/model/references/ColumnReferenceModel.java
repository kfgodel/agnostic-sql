package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents an explicit sql reference to a column
 * Created by kfgodel on 12/07/15.
 */
public class ColumnReferenceModel implements AgnosticModel {

    private String columnName;

    public String getColumnName() {
        return columnName;
    }

    public static ColumnReferenceModel create(String columnName) {
        ColumnReferenceModel reference = new ColumnReferenceModel();
        reference.columnName = columnName;
        return reference;
    }

    @Override
    public String getTemplatePath() {
        return "/references/_column.ftl";
    }
}
