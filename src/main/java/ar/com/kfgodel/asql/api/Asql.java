package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.constraints.NamedConstraint;
import ar.com.kfgodel.asql.api.create.TableDefinedCreate;
import ar.com.kfgodel.asql.api.delete.UnrestrictedDeleteStatement;
import ar.com.kfgodel.asql.api.drop.DropStatement;
import ar.com.kfgodel.asql.api.insert.TableDefinedInsert;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.scripts.AgnosticScript;
import ar.com.kfgodel.asql.api.select.ProjectionDefinedSelect;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface Asql {

    TableDefinedUpdate update(String tableName);

    NamedColumn column(String columnName);

    TableDefinedCreate create(String tableName);

    TableDefinedAlter alter(String tableName);

    UnrestrictedDeleteStatement deleteFrom(String tableName);

    DropStatement drop(String tableName);

    NamedConstraint constraint(String constraintName);

    TableDefinedInsert insertInto(String tableName);

    AgnosticScript asScript(AgnosticStatement... statements);

    ProjectionDefinedSelect select(Object... expressions);
}
