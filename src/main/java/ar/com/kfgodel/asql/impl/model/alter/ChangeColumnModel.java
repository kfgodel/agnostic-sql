package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class ChangeColumnModel extends TableCenteredModel {

  private ColumnDeclarationModel columnDeclaration;

  public ColumnDeclarationModel getColumnDeclaration() {
    return columnDeclaration;
  }

  public void setColumnDeclaration(ColumnDeclarationModel columnDeclaration) {
    this.columnDeclaration = columnDeclaration;
  }

  public static ChangeColumnModel create(TableReferenceModel table, ColumnDeclarationModel column) {
    ChangeColumnModel model = new ChangeColumnModel();
    model.setTable(table);
    model.columnDeclaration = column;
    return model;
  }

  @Override
  public String getTemplatePath() {
    return "/alter/change_column_type.ftl";
  }
}
