package ar.com.kfgodel.asql.api.select;

/**
 * This type represents a minimum agnostic select statement without tables or where clauses
 * Created by tenpines on 23/09/15.
 */
public interface ProjectionDefinedSelect extends SelectStatement {
  TableDefinedSelect from(String... tableNames);
}
