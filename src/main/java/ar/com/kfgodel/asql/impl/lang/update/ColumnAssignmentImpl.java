package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.functions.FunctionInvocation;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;

/**
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentImpl implements ColumnAssignment {

    private ColumnReference column;
    private Object columnValue;

    @Override
    public ColumnAssignmentModel parseModel() {
        AgnosticModel operand;
        if(columnValue instanceof FunctionInvocation){
            // Functions are already an operand
            FunctionInvocation function = (FunctionInvocation) this.columnValue;
            operand = function.parseModel();
        }else {
            operand = Internal.literal(columnValue).parseModel();
        }
        return ColumnAssignmentModel.create(column.parseModel(), operand);
    }

    public static ColumnAssignmentImpl create(ColumnReference column, Object columnValue) {
        ColumnAssignmentImpl assignment = new ColumnAssignmentImpl();
        assignment.column = column;
        assignment.columnValue = columnValue;
        return assignment;
    }

}
