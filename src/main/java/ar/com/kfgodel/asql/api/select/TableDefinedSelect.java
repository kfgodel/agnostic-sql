package ar.com.kfgodel.asql.api.select;

import ar.com.kfgodel.asql.api.AgnosticStatement;

/**
 * This type represents a select statement with table references defined
 * Created by tenpines on 27/09/15.
 */
public interface TableDefinedSelect extends AgnosticStatement, SelectStatement {
    RestrictedSelect where(Object condition);
}
