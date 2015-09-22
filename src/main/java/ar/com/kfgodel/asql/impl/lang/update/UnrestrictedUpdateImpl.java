package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.api.update.RestrictedUpdate;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kfgodel on 12/07/15.
 */
public class UnrestrictedUpdateImpl implements UnrestrictedUpdate {

    private TableDefinedUpdateImpl tableUpdate;
    private List<ColumnAssignment> assignments;

    @Override
    public RestrictedUpdate where(QueryCondition condition) {
        return RestrictedUpdateImpl.create(this, condition);
    }

    @Override
    public UpdateModel parseModel() {
        return UpdateModel.create(tableUpdate.getTable().parseModel(), parseColumnAssignmentModels());
    }

    private List<ColumnAssignmentModel> parseColumnAssignmentModels() {
        List<ColumnAssignmentModel> parsedAssignments = assignments.stream()
                .map(ColumnAssignment::parseModel)
                .collect(Collectors.toList());
        return parsedAssignments;
    }

    public static UnrestrictedUpdateImpl create(TableDefinedUpdateImpl tableUpdate, List<ColumnAssignment> assignments) {
        UnrestrictedUpdateImpl unconditionedUpdate = new UnrestrictedUpdateImpl();
        unconditionedUpdate.tableUpdate = tableUpdate;
        unconditionedUpdate.assignments = assignments;
        return unconditionedUpdate;
    }

}
