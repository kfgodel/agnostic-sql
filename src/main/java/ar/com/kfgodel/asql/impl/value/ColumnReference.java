package ar.com.kfgodel.asql.impl.value;

/**
 * This type represents an explicit sql reference to a column
 * Created by kfgodel on 12/07/15.
 */
public class ColumnReference implements ExplicitOperand {

    private String columnName;

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public boolean isSubquery() {
        return false;
    }

    @Override
    public Object getValue() {
        return columnName;
    }

    public static ColumnReference create(String columnName) {
        ColumnReference reference = new ColumnReference();
        reference.columnName = columnName;
        return reference;
    }

}
