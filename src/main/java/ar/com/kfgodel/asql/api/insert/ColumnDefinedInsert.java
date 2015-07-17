package ar.com.kfgodel.asql.api.insert;

/**
 * Created by kfgodel on 16/07/15.
 */
public interface ColumnDefinedInsert {
    InsertStatement to(Object... values);
}
