package ar.com.kfgodel.asql.impl.lang.create;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.create.ColumnDefinedCreate;
import ar.com.kfgodel.asql.api.create.TableDefinedCreate;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class TableDefinedCreateImpl extends TableCenteredStatement implements TableDefinedCreate {

  @Override
  public ColumnDefinedCreate with(ColumnDeclaration... declarations) {
    return ColumnDefinedCreateImpl.create(this, declarations);
  }

  @Override
  public ColumnDefinedCreate withIdPk() {
    return PkDefinedCreateImpl.create(this);
  }

  @Override
  public CreateModel parseModel() {
    return CreateModel.create(getTable().parseModel());
  }

  public static TableDefinedCreateImpl create(TableReference table) {
    TableDefinedCreateImpl create = new TableDefinedCreateImpl();
    create.setTable(table);
    return create;
  }

}
