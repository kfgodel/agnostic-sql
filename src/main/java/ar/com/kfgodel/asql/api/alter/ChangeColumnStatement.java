package ar.com.kfgodel.asql.api.alter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.alter.ChangeColumnModel;

/**
 * This type represents an agnostic column change statement
 * Created by kfgodel on 15/07/15.
 */
public interface ChangeColumnStatement extends AgnosticStatement {

  @Override
  ChangeColumnModel parseModel();

  /**
   * @return A new statemet to modify the column definition so it accepts null values
   */
  ChangeNullabilityStatement toNullable();

  /**
   * @return A new statement to modify the column definition so it doesn't accept null values
   */
  ChangeNullabilityStatement toNonNullable();
}
