package ar.com.kfgodel.asql.api.update;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface TableDefinedUpdate {
    PartialUpdateSet set(String columnName);
}
