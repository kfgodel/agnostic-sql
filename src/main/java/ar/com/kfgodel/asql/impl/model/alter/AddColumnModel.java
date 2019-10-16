package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * This type represents the agnostic model of a column addition
 * Created by kfgodel on 14/07/15.
 */
public class AddColumnModel extends TableCenteredModel {

  private ColumnDeclarationModel columnDeclaration;

  public ColumnDeclarationModel getColumnDeclaration() {
    return columnDeclaration;
  }

  public void setColumnDeclaration(ColumnDeclarationModel columnDeclaration) {
    this.columnDeclaration = columnDeclaration;
  }

  public static AddColumnModel create(TableReferenceModel table, ColumnDeclarationModel columnDeclaration) {
    AddColumnModel model = new AddColumnModel();
    model.setTable(table);
    model.columnDeclaration = columnDeclaration;
    return model;
  }

  @Override
  public String getTemplatePath() {
    return "/alter/add_column.ftl";
  }
}
