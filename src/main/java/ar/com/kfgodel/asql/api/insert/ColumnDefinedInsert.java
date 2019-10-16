package ar.com.kfgodel.asql.api.insert;

import ar.com.kfgodel.asql.api.select.SelectStatement;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface ColumnDefinedInsert {
  InsertStatement to(Object... values);

  InsertStatement to(SelectStatement subquery);
}
