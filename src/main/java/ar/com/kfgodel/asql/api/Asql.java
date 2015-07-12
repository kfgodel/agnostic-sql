package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.impl.AsqlBuilderImpl;

/**
 * This type serves as the entry point of the asql api
 * Created by kfgodel on 11/07/15.
 */
public interface Asql {
    static TableDefinedUpdate update(String tableName) {
        return AsqlBuilderImpl.create().update(tableName);
    }

    static VendorDialect sqlserver() {
        return null;
    }
}
