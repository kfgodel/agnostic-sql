package ar.com.kfgodel.asql.impl.lang.indices;

import ar.com.kfgodel.asql.api.indices.NameDefinedCreateIndex;
import ar.com.kfgodel.asql.api.indices.TableDefinedCreateIndex;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.IndexReference;

/**
 * Created by tenpines on 27/09/15.
 */
public class NameDefinedCreateIndexImpl implements NameDefinedCreateIndex {


  private IndexReference index;

  public IndexReference getIndex() {
    return index;
  }

  @Override
  public TableDefinedCreateIndex on(String tableName) {
    return TableDefinedCreateIndexImpl.create(this, Internal.table(tableName));
  }

  public static NameDefinedCreateIndexImpl create(IndexReference index) {
    NameDefinedCreateIndexImpl createIndex = new NameDefinedCreateIndexImpl();
    createIndex.index = index;
    return createIndex;
  }

}
