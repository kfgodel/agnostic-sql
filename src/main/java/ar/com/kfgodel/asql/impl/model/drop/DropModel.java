package ar.com.kfgodel.asql.impl.model.drop;

import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class DropModel extends TableCenteredModel {

  public static DropModel create(TableReferenceModel table) {
    DropModel model = new DropModel();
    model.setTable(table);
    return model;
  }

  @Override
  public String getTemplatePath() {
    return "/drop/drop.ftl";
  }
}
