package ar.com.kfgodel.asql.api.columns;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;

/**
 * This type represents the definition of a column assignment
 * Created by kfgodel on 12/07/15.
 */
public interface ColumnAssignment extends AgnosticConstruct {

    @Override
    ColumnAssignmentModel parseModel();

    AgnosticConstruct getValue();

    ColumnReference getColumn();
}
