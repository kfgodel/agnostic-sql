package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
import ar.com.kfgodel.asql.api.create.TableDefinedCreate;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface AsqlBuilder {

    TableDefinedUpdate update(String tableName);

    NamedColumn column(String columnName);

    TableDefinedCreate create(String tableName);

    TableDefinedAlter alter(String tableName);
}
