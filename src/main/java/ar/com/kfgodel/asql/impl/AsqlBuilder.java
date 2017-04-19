package ar.com.kfgodel.asql.impl;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.Asql;
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
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.alter.TableDefinedAlterImpl;
import ar.com.kfgodel.asql.impl.lang.constraints.NamedConstraintImpl;
import ar.com.kfgodel.asql.impl.lang.create.TableDefinedCreateImpl;
import ar.com.kfgodel.asql.impl.lang.custom.CustomConstructImpl;
import ar.com.kfgodel.asql.impl.lang.delete.UnrestrictedDeleteStatementImpl;
import ar.com.kfgodel.asql.impl.lang.drop.DropStatementImpl;
import ar.com.kfgodel.asql.impl.lang.indices.NameDefinedCreateIndexImpl;
import ar.com.kfgodel.asql.impl.lang.indices.NameDefinedDropIndexImpl;
import ar.com.kfgodel.asql.impl.lang.insert.TableDefinedInsertImpl;
import ar.com.kfgodel.asql.impl.lang.restrictions.NamedColumnImpl;
import ar.com.kfgodel.asql.impl.lang.scripts.AgnosticScriptImpl;
import ar.com.kfgodel.asql.impl.lang.select.ProjectionDefinedSelectImpl;
import ar.com.kfgodel.asql.impl.lang.transactions.BeginTransaction;
import ar.com.kfgodel.asql.impl.lang.transactions.CommitTransaction;
import ar.com.kfgodel.asql.impl.lang.transactions.RollbackTransaction;
import ar.com.kfgodel.asql.impl.lang.update.TableDefinedUpdateImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This type represents the base builder for creating agnostic constructs
 * <p>
 * Created by kfgodel on 11/07/15.
 */
public class AsqlBuilder implements Asql {

  public static AsqlBuilder create() {
    AsqlBuilder builder = new AsqlBuilder();
    return builder;
  }

  @Override
  public TableDefinedUpdate update(String tableName) {
    return TableDefinedUpdateImpl.create(Internal.table(tableName));
  }

  @Override
  public NamedColumn column(String columnName) {
    return NamedColumnImpl.create(Internal.column(columnName));
  }

  @Override
  public TableDefinedCreate createTable(String tableName) {
    return TableDefinedCreateImpl.create(Internal.table(tableName));
  }

  @Override
  public TableDefinedAlter alter(String tableName) {
    return TableDefinedAlterImpl.create(Internal.table(tableName));
  }

  @Override
  public UnrestrictedDeleteStatement deleteFrom(String tableName) {
    return UnrestrictedDeleteStatementImpl.create(Internal.table(tableName));
  }

  @Override
  public DropStatement dropTable(String tableName) {
    return DropStatementImpl.create(Internal.table(tableName));
  }

  @Override
  public NamedConstraint constraint(String constraintName) {
    return NamedConstraintImpl.create(Internal.constraint(constraintName));
  }

  @Override
  public TableDefinedInsert insertInto(String tableName) {
    return TableDefinedInsertImpl.create(Internal.table(tableName));
  }

  @Override
  public AgnosticScript asScript(AgnosticStatement... statements) {
    List<AgnosticStatement> statementList = Arrays.stream(statements).collect(Collectors.toList());
    return AgnosticScriptImpl.create(statementList);
  }

  @Override
  public ProjectionDefinedSelect select(Object... projections) {
    List<AgnosticConstruct> projectionConstructs = Arrays.stream(projections)
      .map(Internal::asConstruct)
      .collect(Collectors.toList());
    return ProjectionDefinedSelectImpl.create(projectionConstructs);
  }

  @Override
  public NameDefinedCreateIndex createIndex(String indexName) {
    return NameDefinedCreateIndexImpl.create(Internal.index(indexName));
  }

  @Override
  public NameDefinedDropIndex dropIndex(String indexName) {
    return NameDefinedDropIndexImpl.create(Internal.index(indexName));
  }

  @Override
  public AgnosticStatement begin() {
    return BeginTransaction.create();
  }

  @Override
  public AgnosticStatement commit() {
    return CommitTransaction.create();
  }

  @Override
  public AgnosticStatement rollback() {
    return RollbackTransaction.create();
  }

  @Override
  public CustomConstruct customSql(String translatedSql) {
    return CustomConstructImpl.create(translatedSql);
  }
}
