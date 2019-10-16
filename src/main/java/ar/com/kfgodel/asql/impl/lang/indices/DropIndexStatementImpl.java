package ar.com.kfgodel.asql.impl.lang.indices;

import ar.com.kfgodel.asql.api.indices.DropIndexStatement;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.model.indices.DropIndexModel;

/**
 * Created by tenpines on 27/09/15.
 */
public class DropIndexStatementImpl implements DropIndexStatement {

  private NameDefinedDropIndexImpl previousNode;
  private TableReference table;

  @Override
  public DropIndexModel parseModel() {
    return DropIndexModel.create(previousNode.getIndex().parseModel(), table.parseModel());
  }

  public static DropIndexStatementImpl create(NameDefinedDropIndexImpl previousNode, TableReference table) {
    DropIndexStatementImpl drop = new DropIndexStatementImpl();
    drop.previousNode = previousNode;
    drop.table = table;
    return drop;
  }

}
