package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.ColumnDefinedFk;
import ar.com.kfgodel.asql.api.constraints.NamedConstraint;

/**
 * Created by kfgodel on 16/07/15.
 */
public class NamedConstraintImpl implements NamedConstraint {

    private String constraintName;

    public String getConstraintName() {
        return constraintName;
    }

    @Override
    public ColumnDefinedFk fkFrom(String columnName) {
        return ColumnDefinedFkImpl.create(this, columnName);
    }

    public static NamedConstraintImpl create(String contraintName) {
        NamedConstraintImpl constraint = new NamedConstraintImpl();
        constraint.constraintName = contraintName;
        return constraint;
    }

}
