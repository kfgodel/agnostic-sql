package ar.com.kfgodel.asql.impl;

import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.api.condition.NamedColumn;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.impl.lang.condition.NamedColumnImpl;
import ar.com.kfgodel.asql.impl.lang.update.TableDefinedUpdateImpl;

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
        return TableDefinedUpdateImpl.create(tableName);
    }

    @Override
    public NamedColumn column(String columnName) {
        return NamedColumnImpl.create(columnName);
    }
}
