package ar.com.kfgodel.asql.api.columns;

import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.lang.Parseable;

/**
 * This type represents the definition of a column assignment
 * Created by kfgodel on 12/07/15.
 */
public interface ColumnAssignment extends Parseable {

    @Override
    ColumnAssignmentModel parseModel();
}
