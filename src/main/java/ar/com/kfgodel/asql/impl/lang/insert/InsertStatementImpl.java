package ar.com.kfgodel.asql.impl.lang.insert;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.impl.model.insert.InsertModel;

import java.util.List;

/**
 * Created by kfgodel on 16/07/15.
 */
public class InsertStatementImpl implements InsertStatement {

    private TableDefinedInsertImpl previousNode;
    private List<ColumnAssignment> assignments;

    @Override
    public InsertModel parseModel() {
        InsertModel model = InsertModel.create(previousNode.getTable().parseModel());
        for (ColumnAssignment assignment : assignments) {
            model.addAssignment(assignment.parseModel());
        }
        return model;
    }

    public static InsertStatementImpl create(TableDefinedInsertImpl previousNode, List<ColumnAssignment> assignments) {
        InsertStatementImpl statement = new InsertStatementImpl();
        statement.previousNode = previousNode;
        statement.assignments = assignments;
        return statement;
    }

}
