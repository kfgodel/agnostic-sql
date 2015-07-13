package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.update.ColumnAssignment;
import ar.com.kfgodel.asql.impl.model.update.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.value.ExplicitValueModel;

/**
 * Created by kfgodel on 12/07/15.
 */
public class ColumnAssignmentImpl implements ColumnAssignment {

    private String columnName;
    private Object columnValue;

    @Override
    public ColumnAssignmentModel parseModel() {
        return ColumnAssignmentModel.create(columnName, ExplicitValueModel.create(columnValue));
    }

    public static ColumnAssignmentImpl create(String columnName, Object columnValue) {
        ColumnAssignmentImpl assignment = new ColumnAssignmentImpl();
        assignment.columnName = columnName;
        assignment.columnValue = columnValue;
        return assignment;
    }

}
