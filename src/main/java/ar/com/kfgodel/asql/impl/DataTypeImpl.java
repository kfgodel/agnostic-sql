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

}
