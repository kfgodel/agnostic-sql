package ar.com.kfgodel.asql.impl.lang.delete;

import ar.com.kfgodel.asql.api.delete.DeleteStatement;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class DeleteStatementImpl implements DeleteStatement {

    private String tableName;

    @Override
    public DeleteModel parseModel() {
        return DeleteModel.create(tableName);
    }

    public static DeleteStatementImpl create(String tableName) {
        DeleteStatementImpl statement = new DeleteStatementImpl();
        statement.tableName = tableName;
        return statement;
    }

}
