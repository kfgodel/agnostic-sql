package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

/**
 * This type represents a language reference to a table
 * Created by tenpines on 21/09/15.
 */
public class TableReference implements AgnosticConstruct {

  private String tableName;

  public String getTableName() {
    return tableName;
  }

  @Override
  public TableReferenceModel parseModel() {
    return TableReferenceModel.create(tableName);
  }

  public static TableReference create(String tableName) {
    TableReference reference = new TableReference();
    reference.tableName = tableName;
    return reference;
  }

}
