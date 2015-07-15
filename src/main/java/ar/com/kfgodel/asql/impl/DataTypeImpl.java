package ar.com.kfgodel.asql.impl;

import ar.com.kfgodel.asql.api.DataType;

/**
 * Created by kfgodel on 13/07/15.
 */
public class DataTypeImpl implements DataType {

    private String name;

    @Override
    public String getAgnosticName() {
        return name;
    }

    public static DataTypeImpl create(String name) {
        DataTypeImpl type = new DataTypeImpl();
        type.name = name;
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataType)) return false;

        DataType that = (DataType) o;

        return this.getAgnosticName().equals(that.getAgnosticName());
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
