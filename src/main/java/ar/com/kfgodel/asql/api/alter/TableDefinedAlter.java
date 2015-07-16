package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.constraints.NamedConstraintDeclaration;

/**
 * Created by kfgodel on 14/07/15.
 */
public interface TableDefinedAlter {

    AddColumnStatement adding(ColumnDeclaration newColumnDeclaration);

    AddConstraintStatement adding(NamedConstraintDeclaration newConstraint);

    RemoveColumnStatement removing(String columnName);

    ChangeColumnStatement changing(ColumnDeclaration columnChange);
}
