package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.impl.DataTypeImpl;

/**
 * This type represents an agnostic data type that can be translated to a vendor specific type
 * Created by kfgodel on 13/07/15.
 */
public interface DataType {

    String getAgnosticName();

    static DataType bigint() {
        return DataTypeImpl.create("bigint");
    }

    static DataType timestamp() {
        return DataTypeImpl.create("timestamp");
    }

    static DataType integer() {
        return DataTypeImpl.create("integer");
    }

    static DataType fk() {
        return DataTypeImpl.create("fk");
    }

    static DataType pk() {
        return DataTypeImpl.create("pk");
    }

    static DataType shortString() {
        return DataTypeImpl.create("shortstring");
    }
}
