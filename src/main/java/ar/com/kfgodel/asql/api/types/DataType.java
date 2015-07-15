package ar.com.kfgodel.asql.api.types;

import ar.com.kfgodel.asql.impl.lang.types.DataTypeImpl;

/**
 * This type represents an agnostic data type that can be translated to a vendor specific type
 * Created by kfgodel on 13/07/15.
 */
public interface DataType  {

    String getAgnosticName();

    static DataType bigInteger() {
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

    static DataType largeText() {
        return DataTypeImpl.create("largetext");
    }

    static DataType date() {
        return DataTypeImpl.create("date");
    }

    static DataType booleanic() {
        return DataTypeImpl.create("booleanic");
    }
}
