package ar.com.kfgodel.asql.api.alter;

/**
 * This type represents a partially defined rename (it lacks the new name)
 * Created by tenpines on 27/09/15.
 */
public interface ColumnDefinedRename {
  RenameColumnStatement to(String newName);
}
