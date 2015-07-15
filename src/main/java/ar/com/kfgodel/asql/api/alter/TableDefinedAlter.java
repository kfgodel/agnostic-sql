package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.create.ColumnDeclaration;

/**
 * Created by kfgodel on 14/07/15.
 */
public interface TableDefinedAlter {

    AddColumnStatement adding(ColumnDeclaration newColumnDeclaration);

    RemoveColumnStatement removing(String columnName);
}
