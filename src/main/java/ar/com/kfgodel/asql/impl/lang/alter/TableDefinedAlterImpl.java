package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.AddColumnStatement;
import ar.com.kfgodel.asql.api.alter.AddConstraintStatement;
import ar.com.kfgodel.asql.api.alter.ChangeColumnStatement;
import ar.com.kfgodel.asql.api.alter.ColumnDefinedRename;
import ar.com.kfgodel.asql.api.alter.RemoveColumnStatement;
import ar.com.kfgodel.asql.api.alter.RemoveConstraintStatement;
import ar.com.kfgodel.asql.api.alter.RenameTableStatement;
import ar.com.kfgodel.asql.api.alter.TableDefinedAlter;
import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.constraints.ConstraintDeclaration;
import ar.com.kfgodel.asql.api.constraints.NamedConstraint;
import ar.com.kfgodel.asql.api.restrictions.NamedColumn;
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
  public AddConstraintStatement adding(ConstraintDeclaration newConstraint) {
    return AddConstraintStatementImpl.create(this, newConstraint);
  }

  @Override
  public RemoveColumnStatement removing(NamedColumn columnName) {
    return RemoveColumnStatementImpl.create(this, columnName.getColumnReference());
  }

  @Override
  public ChangeColumnStatement changing(ColumnDeclaration columnChange) {
    return ChangeColumnStatementImpl.create(this, columnChange);
  }

  @Override
  public ColumnDefinedRename renaming(NamedColumn previousName) {
    return ColumnDefinedRenameImpl.create(this, previousName);
  }

  @Override
  public RenameTableStatement renameTo(String newName) {
    return RenameTableStatementImpl.create(this, newName);
  }

  @Override
  public RemoveConstraintStatement removing(NamedConstraint namedConstraint) {
    return RemoveConstraintStatementImpl.create(this, namedConstraint.getConstraintReference());
  }
}
