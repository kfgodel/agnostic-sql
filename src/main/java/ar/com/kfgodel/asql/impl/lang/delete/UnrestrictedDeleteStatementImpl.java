package ar.com.kfgodel.asql.impl.lang.delete;

import ar.com.kfgodel.asql.api.delete.RestrictedDeleteStatement;
import ar.com.kfgodel.asql.api.delete.UnrestrictedDeleteStatement;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class UnrestrictedDeleteStatementImpl extends TableCenteredStatement implements UnrestrictedDeleteStatement {

    @Override
    public DeleteModel parseModel() {
        return DeleteModel.create(getTableName());
    }

    @Override
    public RestrictedDeleteStatement where(QueryCondition condition) {
        return RestrictedDeleteStatementImpl.create(this,condition);
    }

    public static UnrestrictedDeleteStatementImpl create(String tableName) {
        UnrestrictedDeleteStatementImpl statement = new UnrestrictedDeleteStatementImpl();
        statement.setTableName(tableName);
        return statement;
    }

}