package ar.com.kfgodel.asql.impl.lang.column;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.nullability.NullabilityConstraint;
import ar.com.kfgodel.asql.impl.lang.operators.Operator;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;

/**
 * This type represents the nullability definition for a columna declaration
 * Created by dario.garcia on 28/02/17.
 */
public class NullabilityDeclaration implements ColumnDeclaration {

  private ColumnDeclaration previousNode;
  private NullabilityConstraint nullability;

  @Override
  public ColumnDeclaration nonNullable() {
    return makeNonNullable(previousNode);
  }

  @Override
  public ColumnDeclaration nullable() {
    return makeNullable(previousNode);
  }

  @Override
  public ColumnDeclaration defaultedTo(Object columnValue) {
    return DefaultedColumnDeclaration.create(this, columnValue);
  }

  @Override
  public ColumnDeclarationModel parseModel() {
    ColumnDeclarationModel columnModel = previousNode.parseModel();
    NullabilityModel nullabilityModel = nullability.parseModel();
    columnModel.withNullability(nullabilityModel);
    return columnModel;
  }

  public static ColumnDeclaration makeNonNullable(ColumnDeclaration previousNode) {
    return NullabilityDeclaration.create(previousNode, Operator.notPlacedBefore(Internal.nullRef()));
  }

  public static ColumnDeclaration makeNullable(ColumnDeclaration previousNode) {
    return NullabilityDeclaration.create(previousNode, Internal.nullRef());
  }

  public static NullabilityDeclaration create(ColumnDeclaration previousNode, NullabilityConstraint nullabilityConstraint) {
    NullabilityDeclaration declaration = new NullabilityDeclaration();
    declaration.previousNode = previousNode;
    declaration.nullability = nullabilityConstraint;
    return declaration;
  }

}
