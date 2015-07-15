package ar.com.kfgodel.asql.impl.model.types;

import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class TypeReference implements AgnosticModel {
    private DataType type;

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public static TypeReference create(DataType type) {
        TypeReference testType = new TypeReference();
        testType.type = type;
        return testType;
    }

}
