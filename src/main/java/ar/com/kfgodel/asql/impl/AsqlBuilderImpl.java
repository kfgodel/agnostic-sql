package ar.com.kfgodel.asql.impl;

import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.api.condition.NamedColumn;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;

/**
 * Created by kfgodel on 11/07/15.
 */
public class AsqlBuilderImpl implements AsqlBuilder {

    public static AsqlBuilderImpl create() {
        AsqlBuilderImpl builder = new AsqlBuilderImpl();
        return builder;
    }

    @Override
    public TableDefinedUpdate update(String tableName) {
        return null;
    }

    @Override
    public NamedColumn column(String columnName) {
        return null;
    }
}
