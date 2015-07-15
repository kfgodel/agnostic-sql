package ar.com.kfgodel.asql.impl.model.value;

/**
 * Created by kfgodel on 12/07/15.
 */
public class NullOperand implements ExplicitOperand {


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
        return "NULL";
    }

    public static NullOperand create() {
        NullOperand value = new NullOperand();
        return value;
    }

}
