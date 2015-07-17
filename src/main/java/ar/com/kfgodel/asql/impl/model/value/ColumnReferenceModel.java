package ar.com.kfgodel.asql.impl.model.value;

/**
 * This type represents an explicit sql reference to a column
 * Created by kfgodel on 12/07/15.
 */
public class ColumnReferenceModel implements ExplicitOperand {

    private String columnName;

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public boolean isFunction() {
        return false;
    }

    @Override
    public boolean isSubquery() {
        return false;
    }

    @Override
    public boolean isPredicate() {
        return false;
    }

    @Override
    public Object getValue() {
        return columnName;
    }

    public static ColumnReferenceModel create(String columnName) {
        ColumnReferenceModel reference = new ColumnReferenceModel();
        reference.columnName = columnName;
        return reference;
    }

}