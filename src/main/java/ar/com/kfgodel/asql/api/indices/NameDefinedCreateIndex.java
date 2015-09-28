package ar.com.kfgodel.asql.api.indices;

/**
 * Created by tenpines on 27/09/15.
 */
public interface NameDefinedCreateIndex {
    TableDefinedCreateIndex on(String tableName);
}
