package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.api.update.ColumnAssignment;
import ar.com.kfgodel.asql.api.update.RestrictedUpdate;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;

import java.util.List;

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
        UpdateModel updateModel = tableUpdate.parseModel();
        for (ColumnAssignment columnAssignment : assignments) {
            updateModel.addAssignment(columnAssignment.parseModel());
        }
        return updateModel;
    }

    public static UnrestrictedUpdateImpl create(TableDefinedUpdateImpl tableUpdate, List<ColumnAssignment> assignments) {
        UnrestrictedUpdateImpl unconditionedUpdate = new UnrestrictedUpdateImpl();
        unconditionedUpdate.tableUpdate = tableUpdate;
        unconditionedUpdate.assignments = assignments;
        return unconditionedUpdate;
    }

}
