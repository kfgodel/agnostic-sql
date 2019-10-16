package ar.com.kfgodel.asql.impl.model.support;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

/**
 * This type serves as base clase for models that are centered around a table
 * Created by kfgodel on 15/07/15.
 */
public abstract class TableCenteredModel implements AgnosticModel {

  private TableReferenceModel table;

  public TableReferenceModel getTable() {
    return table;
  }

  public void setTable(TableReferenceModel table) {
    this.table = table;
  }
}
