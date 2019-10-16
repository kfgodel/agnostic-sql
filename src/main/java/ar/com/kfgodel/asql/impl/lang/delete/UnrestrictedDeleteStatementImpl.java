package ar.com.kfgodel.asql.impl.lang.delete;

import ar.com.kfgodel.asql.api.delete.RestrictedDeleteStatement;
import ar.com.kfgodel.asql.api.delete.UnrestrictedDeleteStatement;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class UnrestrictedDeleteStatementImpl extends TableCenteredStatement implements UnrestrictedDeleteStatement {

  @Override
  public DeleteModel parseModel() {
    return DeleteModel.create(getTable().parseModel());
  }

  @Override
  public RestrictedDeleteStatement where(Object condition) {
    return RestrictedDeleteStatementImpl.create(this, Internal.asConstruct(condition));
  }

  public static UnrestrictedDeleteStatementImpl create(TableReference table) {
    UnrestrictedDeleteStatementImpl statement = new UnrestrictedDeleteStatementImpl();
    statement.setTable(table);
    return statement;
  }

}
