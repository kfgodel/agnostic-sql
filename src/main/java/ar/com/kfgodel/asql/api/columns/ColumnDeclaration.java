package ar.com.kfgodel.asql.api.columns;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;

/**
 * This type represents the declaration of a new column
 * Created by kfgodel on 14/07/15.
 */
public interface ColumnDeclaration extends AgnosticConstruct {
  /**
   * Indicates that this column declaration is not nullable
   *
   * @return The new restricted column declaration
   */
  ColumnDeclaration nonNullable();

  /**
   * Indicates the default value when none is supplied for this column declaration
   *
   * @param columnValue The default value
   * @return The new column declaration
   */
  ColumnDeclaration defaultedTo(Object columnValue);

  /**
   * Indicates that this column declaration allows null values
   *
   * @return The new declaration
   */
  ColumnDeclaration nullable();

  @Override
  ColumnDeclarationModel parseModel();

}
