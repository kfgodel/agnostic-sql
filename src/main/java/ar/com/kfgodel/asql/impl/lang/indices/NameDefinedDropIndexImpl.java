package ar.com.kfgodel.asql.impl.lang.indices;

import ar.com.kfgodel.asql.api.indices.DropIndexStatement;
import ar.com.kfgodel.asql.api.indices.NameDefinedDropIndex;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.IndexReference;

/**
 * Created by tenpines on 27/09/15.
 */
public class NameDefinedDropIndexImpl implements NameDefinedDropIndex {
  private IndexReference index;

  public IndexReference getIndex() {
    return index;
  }

  @Override
  public DropIndexStatement from(String tableName) {
    return DropIndexStatementImpl.create(this, Internal.table(tableName));
  }

  public static NameDefinedDropIndexImpl create(IndexReference index) {
    NameDefinedDropIndexImpl dropIndex = new NameDefinedDropIndexImpl();
    dropIndex.index = index;
    return dropIndex;
  }


}
