package ar.com.kfgodel.asql.impl.lang.drop;

import ar.com.kfgodel.asql.api.drop.DropStatement;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;
import ar.com.kfgodel.asql.impl.model.drop.DropModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class DropStatementImpl extends TableCenteredStatement implements DropStatement {

    @Override
    public DropModel parseModel() {
        return DropModel.create(getTableName());
    }

    public static DropStatementImpl create(String tableName) {
        DropStatementImpl statement = new DropStatementImpl();
        statement.setTableName(tableName);
        return statement;
    }

}
