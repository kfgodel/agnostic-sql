package ar.com.kfgodel.asql.impl;

import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.delete.DeleteStatement;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.create.TableDefinedCreate;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.impl.lang.alter.TableDefinedAlterImpl;
import ar.com.kfgodel.asql.impl.lang.delete.DeleteStatementImpl;
import ar.com.kfgodel.asql.impl.lang.restrictions.NamedColumnImpl;
import ar.com.kfgodel.asql.impl.lang.create.TableDefinedCreateImpl;
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

    @Override
    public TableDefinedCreate create(String tableName) {
        return TableDefinedCreateImpl.create(tableName);
    }

    @Override
    public TableDefinedAlter alter(String tableName) {
        return TableDefinedAlterImpl.create(tableName);
    }

    @Override
    public DeleteStatement deleteFrom(String tableName) {
        return DeleteStatementImpl.create(tableName);
    }
}
