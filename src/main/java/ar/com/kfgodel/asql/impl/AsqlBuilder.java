package ar.com.kfgodel.asql.impl;

import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.constraints.NamedConstraint;
import ar.com.kfgodel.asql.api.delete.UnrestrictedDeleteStatement;
import ar.com.kfgodel.asql.api.drop.DropStatement;
import ar.com.kfgodel.asql.api.insert.TableDefinedInsert;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.create.TableDefinedCreate;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.impl.lang.alter.TableDefinedAlterImpl;
import ar.com.kfgodel.asql.impl.lang.constraints.NamedConstraintImpl;
import ar.com.kfgodel.asql.impl.lang.delete.UnrestrictedDeleteStatementImpl;
import ar.com.kfgodel.asql.impl.lang.drop.DropStatementImpl;
import ar.com.kfgodel.asql.impl.lang.insert.TableDefinedInsertImpl;
import ar.com.kfgodel.asql.impl.lang.restrictions.NamedColumnImpl;
import ar.com.kfgodel.asql.impl.lang.create.TableDefinedCreateImpl;
import ar.com.kfgodel.asql.impl.lang.update.TableDefinedUpdateImpl;

/**
 * Created by kfgodel on 11/07/15.
 */
public class AsqlBuilder implements Asql {

    public static AsqlBuilder create() {
        AsqlBuilder builder = new AsqlBuilder();
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
    public UnrestrictedDeleteStatement deleteFrom(String tableName) {
        return UnrestrictedDeleteStatementImpl.create(tableName);
    }

    @Override
    public DropStatement drop(String tableName) {
        return DropStatementImpl.create(tableName);
    }

    @Override
    public NamedConstraint constraint(String constraintName) {
        return NamedConstraintImpl.create(constraintName);
    }

    @Override
    public TableDefinedInsert insertInto(String tableName) {
        return TableDefinedInsertImpl.create(tableName);
    }
}
