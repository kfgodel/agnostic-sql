package ar.com.kfgodel.asql.impl.model.value;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents an explicit sql reference to a column
 * Created by kfgodel on 12/07/15.
 */
public class ColumnReferenceModel implements AgnosticModel, ExplicitOperand {

    private String columnName;

    @Override
    public Object getValue() {
        return columnName;
    }

    public static ColumnReferenceModel create(String columnName) {
        ColumnReferenceModel reference = new ColumnReferenceModel();
        reference.columnName = columnName;
        return reference;
    }

    @Override
    public String getTemplatePath() {
        return "/operands/_value.ftl";
    }
}
