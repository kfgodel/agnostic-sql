package ar.com.kfgodel.asql.impl.model.columns;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * This type represents a node in a statement tree for a columna assignment
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentModel implements AgnosticModel {

    private ColumnReferenceModel column;
    private ExplicitOperand assignedValue;

    public ColumnReferenceModel getColumn() {
        return column;
    }

    public void setColumn(ColumnReferenceModel column) {
        this.column = column;
    }

    public ExplicitOperand getAssignedValue() {
        return assignedValue;
    }

    public void setAssignedValue(ExplicitOperand assignedValue) {
        this.assignedValue = assignedValue;
    }

    public static ColumnAssignmentModel create(ColumnReferenceModel column, ExplicitOperand value) {
        ColumnAssignmentModel assignmentNode = new ColumnAssignmentModel();
        assignmentNode.column = column;
        assignmentNode.assignedValue = value;
        return assignmentNode;
    }

    @Override
    public String getTemplatePath() {
        return "/columns/_columnAssignment.ftl";
    }
}
