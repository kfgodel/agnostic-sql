package ar.com.kfgodel.asql.impl.lang.indices;

import ar.com.kfgodel.asql.api.indices.CreateIndexStatement;
import ar.com.kfgodel.asql.api.indices.TableDefinedCreateIndex;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.IndexReference;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;

/**
 * Created by tenpines on 27/09/15.
 */
public class TableDefinedCreateIndexImpl implements TableDefinedCreateIndex {

  private NameDefinedCreateIndexImpl previousNode;
  private TableReference table;

  public IndexReference getIndex() {
    return previousNode.getIndex();
  }

  public TableReference getTable() {
    return table;
  }

  @Override
  public CreateIndexStatement forColumns(String... columns) {
    return CreateIndexStatementImpl.create(this, Internal.columns(columns));
  }

  public static TableDefinedCreateIndexImpl create(NameDefinedCreateIndexImpl previousNode, TableReference table) {
    TableDefinedCreateIndexImpl createIndex = new TableDefinedCreateIndexImpl();
    createIndex.previousNode = previousNode;
    createIndex.table = table;
    return createIndex;
  }

}
