package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.ColumnDefinedFk;
import ar.com.kfgodel.asql.api.constraints.ConstraintDeclaration;
import ar.com.kfgodel.asql.api.constraints.NamedConstraint;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.ConstraintReference;

/**
 * Created by kfgodel on 16/07/15.
 */
public class NamedConstraintImpl implements NamedConstraint {

    private ConstraintReference constraint;

    public ConstraintReference getConstraint() {
        return constraint;
    }

    @Override
    public ColumnDefinedFk fkFrom(String columnName) {
        return ColumnDefinedFkImpl.create(this, Internal.column(columnName));
    }

    @Override
    public ConstraintDeclaration uniqueFor(String... columnNames) {
        return ColumnDefinedUniqueImpl.create(this, Internal.columns(columnNames));
    }

    @Override
    public ConstraintDeclaration pkFor(String columnName) {
        return ColumnDefinedPkImpl.create(this, Internal.column(columnName));
    }

    public static NamedConstraintImpl create(ConstraintReference constraint) {
        NamedConstraintImpl named = new NamedConstraintImpl();
        named.constraint = constraint;
        return named;
    }

}
