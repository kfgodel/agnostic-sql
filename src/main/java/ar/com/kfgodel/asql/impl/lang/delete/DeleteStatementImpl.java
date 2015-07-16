package ar.com.kfgodel.asql.impl.lang.delete;

import ar.com.kfgodel.asql.api.delete.DeleteStatement;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class DeleteStatementImpl extends TableCenteredStatement implements DeleteStatement {

    @Override
    public DeleteModel parseModel() {
        return DeleteModel.create(getTableName());
    }

    public static DeleteStatementImpl create(String tableName) {
        DeleteStatementImpl statement = new DeleteStatementImpl();
        statement.setTableName(tableName);
        return statement;
    }

}
