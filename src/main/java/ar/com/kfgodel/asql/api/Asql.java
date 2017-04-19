package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.constraints.NamedConstraint;
import ar.com.kfgodel.asql.api.create.TableDefinedCreate;
import ar.com.kfgodel.asql.api.custom.CustomConstruct;
import ar.com.kfgodel.asql.api.delete.UnrestrictedDeleteStatement;
import ar.com.kfgodel.asql.api.drop.DropStatement;
import ar.com.kfgodel.asql.api.indices.NameDefinedCreateIndex;
import ar.com.kfgodel.asql.api.indices.NameDefinedDropIndex;
import ar.com.kfgodel.asql.api.insert.TableDefinedInsert;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.scripts.AgnosticScript;
import ar.com.kfgodel.asql.api.select.ProjectionDefinedSelect;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;

/**
 * This type represents the starting point of an statement (or construct to use in) in an agnostic manner
 * This is the root of the api for generating complex expressions
 * Created by kfgodel on 11/07/15.
 */
public interface Asql {

  TableDefinedUpdate update(String tableName);

  NamedColumn column(String columnName);

  TableDefinedCreate createTable(String tableName);

  TableDefinedAlter alter(String tableName);

  UnrestrictedDeleteStatement deleteFrom(String tableName);

  DropStatement dropTable(String tableName);

  NamedConstraint constraint(String constraintName);

  TableDefinedInsert insertInto(String tableName);

  AgnosticScript asScript(AgnosticStatement... statements);

  ProjectionDefinedSelect select(Object... expressions);

  NameDefinedCreateIndex createIndex(String indexName);

  NameDefinedDropIndex dropIndex(String indexName);

  AgnosticStatement begin();

  AgnosticStatement commit();

  AgnosticStatement rollback();

  /**
   * Declares a piece of vendro sql that cannot be translated and should be used as is
   * @param translatedSql The piece of sql to add in the query
   * @return The piece construct to use on statements
   */
  CustomConstruct customSql(String translatedSql);
}
