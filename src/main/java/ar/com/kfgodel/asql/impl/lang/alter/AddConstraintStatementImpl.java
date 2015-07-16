package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.AddConstraintStatement;
import ar.com.kfgodel.asql.api.constraints.NamedConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;
import ar.com.kfgodel.asql.impl.model.alter.AddConstraintModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class AddConstraintStatementImpl extends TableCenteredStatement implements AddConstraintStatement {

    private NamedConstraintDeclaration constraintDeclaration;

    @Override
    public AddConstraintModel parseModel() {
        return AddConstraintModel.create(getTableName(), constraintDeclaration.parseModel());
    }

    public static AddConstraintStatementImpl create(String tableName, NamedConstraintDeclaration constraintDeclaration) {
        AddConstraintStatementImpl statement = new AddConstraintStatementImpl();
        statement.setTableName(tableName);
        statement.constraintDeclaration = constraintDeclaration;
        return statement;
    }

}
