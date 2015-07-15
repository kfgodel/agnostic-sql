package ar.com.kfgodel.asql.api.create;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;

/**
 * Created by kfgodel on 14/07/15.
 */
public interface ColumnDefinedCreate extends CreateStatement {

    /**
     * Declares the additional columns that this table must include
     * @param declarations The column declarations
     * @return The new table definition
     */
    ColumnDefinedCreate adding(ColumnDeclaration... declarations);

}
