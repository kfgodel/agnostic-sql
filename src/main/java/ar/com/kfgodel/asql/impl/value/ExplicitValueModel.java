package ar.com.kfgodel.asql.impl.value;

/**
 * This type represents an explicit value that can be represente directly on the template
 * Created by kfgodel on 12/07/15.
 */
public class ExplicitValueModel implements ExplicitOperand {
    private Object value;

    @Override
    public boolean isString() {
        return value instanceof String;
    }

    @Override
    public boolean isSubquery() {
        return false;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public static ExplicitValueModel create(Object value) {
        ExplicitValueModel directValue = new ExplicitValueModel();
        directValue.value = value;
        return directValue;
    }

}