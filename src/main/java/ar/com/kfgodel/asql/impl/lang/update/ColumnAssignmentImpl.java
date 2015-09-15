package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.functions.FunctionInvocation;
import ar.com.kfgodel.asql.impl.lang.references.LiteralReference;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentImpl implements ColumnAssignment {

    private String columnName;
    private Object columnValue;

    @Override
    public ColumnAssignmentModel parseModel() {
        ExplicitOperand operand;
        if(columnValue instanceof FunctionInvocation){
            // Functions are already an operand
            FunctionInvocation function = (FunctionInvocation) this.columnValue;
            operand = function.parseModel();
        }else {
            operand = LiteralReference.create(columnValue).parseModel();
        }
        return ColumnAssignmentModel.create(columnName, operand);
    }

    public static ColumnAssignmentImpl create(String columnName, Object columnValue) {
        ColumnAssignmentImpl assignment = new ColumnAssignmentImpl();
        assignment.columnName = columnName;
        assignment.columnValue = columnValue;
        return assignment;
    }

}
