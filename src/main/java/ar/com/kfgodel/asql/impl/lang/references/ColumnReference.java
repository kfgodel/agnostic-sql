package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

/**
 * This type represents a language reference to a column name
 * Created by tenpines on 14/09/15.
 */
public class ColumnReference implements AgnosticConstruct {

  private String columnName;

  public String getColumnName() {
    return columnName;
  }

  @Override
  public ColumnReferenceModel parseModel() {
    return ColumnReferenceModel.create(columnName);
  }

  public static ColumnReference create(String columnName) {
    ColumnReference reference = new ColumnReference();
    reference.columnName = columnName;
    return reference;
  }

}
