package ar.com.kfgodel.asql.api.constraints;

import ar.com.kfgodel.asql.impl.lang.references.ConstraintReference;

/**
 * This type represents the start declaration of a constraint
 * Created by kfgodel on 16/07/15.
 */
public interface NamedConstraint {

  ColumnDefinedFk fkFrom(String... columnName);

  ConstraintDeclaration uniqueFor(String... columnNames);

  ConstraintDeclaration pkFor(String... columnName);

  ConstraintReference getConstraintReference();
}
