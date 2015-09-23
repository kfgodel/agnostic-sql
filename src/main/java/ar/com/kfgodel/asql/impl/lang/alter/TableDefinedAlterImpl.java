package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.*;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.constraints.NamedConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;

/**
 * Created by kfgodel on 14/07/15.
 */
public class TableDefinedAlterImpl extends TableCenteredStatement implements TableDefinedAlter {

    public static TableDefinedAlterImpl create(TableReference table) {
        TableDefinedAlterImpl alter = new TableDefinedAlterImpl();
        alter.setTable(table);
        return alter;
    }

    @Override
    public AddColumnStatement adding(ColumnDeclaration newColumnDeclaration) {
        return AddColumnStatementImpl.create(this, newColumnDeclaration);
    }

    @Override
    public AddConstraintStatement adding(NamedConstraintDeclaration newConstraint) {
        return AddConstraintStatementImpl.create(this, newConstraint);
    }

    @Override
    public RemoveColumnStatement removing(String columnName) {
        return RemoveColumnStatementImpl.create(this, Internal.column(columnName));
    }

    @Override
    public ChangeColumnStatement changing(ColumnDeclaration columnChange) {
        return ChangeColumnStatementImpl.create(this,columnChange);
    }
}
