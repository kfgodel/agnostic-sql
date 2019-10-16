package ar.com.kfgodel.asql.impl.lang.column;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.Parseable;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;

import static ar.com.kfgodel.asql.impl.lang.column.NullabilityDeclaration.makeNonNullable;
import static ar.com.kfgodel.asql.impl.lang.column.NullabilityDeclaration.makeNullable;

/**
 * Created by kfgodel on 14/07/15.
 */
public class DefaultedColumnDeclaration implements ColumnDeclaration {

  private ColumnDeclaration previousNode;
  private Parseable defaultValue;

  @Override
  public ColumnDeclaration nonNullable() {
    return makeNonNullable(this);
  }

  @Override
  public ColumnDeclaration nullable() {
    return makeNullable(this);
  }

  @Override
  public ColumnDeclaration defaultedTo(Object columnValue) {
    return DefaultedColumnDeclaration.create(previousNode, columnValue);
  }

  @Override
  public ColumnDeclarationModel parseModel() {
    ColumnDeclarationModel columnModel = previousNode.parseModel();
    columnModel.setDefaultValue(defaultValue.parseModel());
    return columnModel;
  }

  public static DefaultedColumnDeclaration create(ColumnDeclaration previousNode, Object value) {
    DefaultedColumnDeclaration declaration = new DefaultedColumnDeclaration();
    declaration.previousNode = previousNode;
    declaration.defaultValue = Internal.literal(value);
    return declaration;
  }

}
