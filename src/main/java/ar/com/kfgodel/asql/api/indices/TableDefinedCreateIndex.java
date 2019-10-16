package ar.com.kfgodel.asql.api.indices;

/**
 * Created by tenpines on 27/09/15.
 */
public interface TableDefinedCreateIndex {
  CreateIndexStatement forColumns(String... columns);
}
