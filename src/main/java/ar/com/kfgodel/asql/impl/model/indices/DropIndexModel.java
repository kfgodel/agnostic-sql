package ar.com.kfgodel.asql.impl.model.indices;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.IndexReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

/**
 * Created by tenpines on 27/09/15.
 */
public class DropIndexModel implements AgnosticModel {

  private IndexReferenceModel index;
  private TableReferenceModel table;

  public IndexReferenceModel getIndex() {
    return index;
  }

  public TableReferenceModel getTable() {
    return table;
  }

  @Override
  public String getTemplatePath() {
    return "/indices/drop_index.ftl";
  }

  public static DropIndexModel create(IndexReferenceModel index, TableReferenceModel table) {
    DropIndexModel dropModel = new DropIndexModel();
    dropModel.index = index;
    dropModel.table = table;
    return dropModel;
  }

}
