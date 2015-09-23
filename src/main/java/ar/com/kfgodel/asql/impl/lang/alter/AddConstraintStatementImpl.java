package ar.com.kfgodel.asql.impl.lang.alter;

import ar.com.kfgodel.asql.api.alter.AddConstraintStatement;
import ar.com.kfgodel.asql.api.constraints.ConstraintDeclaration;
import ar.com.kfgodel.asql.impl.model.alter.AddConstraintModel;

/**
 * Created by kfgodel on 16/07/15.
 */
public class AddConstraintStatementImpl implements AddConstraintStatement {

    private ConstraintDeclaration constraintDeclaration;
    private TableDefinedAlterImpl previousNode;

    @Override
    public AddConstraintModel parseModel() {
        return AddConstraintModel.create(previousNode.getTable().parseModel(), constraintDeclaration.parseModel());
    }

    public static AddConstraintStatementImpl create(TableDefinedAlterImpl previousNode, ConstraintDeclaration constraintDeclaration) {
        AddConstraintStatementImpl statement = new AddConstraintStatementImpl();
        statement.previousNode = previousNode;
        statement.constraintDeclaration = constraintDeclaration;
        return statement;
    }

}
