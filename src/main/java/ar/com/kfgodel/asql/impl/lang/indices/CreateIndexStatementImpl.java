package ar.com.kfgodel.asql.impl.lang.indices;

import ar.com.kfgodel.asql.api.indices.CreateIndexStatement;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.indices.CreateIndexModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tenpines on 27/09/15.
 */
public class CreateIndexStatementImpl implements CreateIndexStatement {
  private TableDefinedCreateIndexImpl previousNode;
  private List<ColumnReference> columns;

  @Override
  public AgnosticModel parseModel() {
    return CreateIndexModel.create(previousNode.getIndex().parseModel(), previousNode.getTable().parseModel(), parseColumnModels());
  }

  private List<ColumnReferenceModel> parseColumnModels() {
    return columns.stream().map(ColumnReference::parseModel).collect(Collectors.toList());
  }

  public static CreateIndexStatementImpl create(TableDefinedCreateIndexImpl previousNode, List<ColumnReference> columns) {
    CreateIndexStatementImpl statement = new CreateIndexStatementImpl();
    statement.previousNode = previousNode;
    statement.columns = columns;
    return statement;
  }

}
