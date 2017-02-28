package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.columns.ColumnNullabilityChangeModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * This type represents the intention to change a column nullability
 * <p>
 * Created by dario.garcia on 28/02/17.
 */
public class ChangeNullabilityModel extends TableCenteredModel {

  private ColumnNullabilityChangeModel nullabilityChange;

  public ColumnNullabilityChangeModel getNullabilityChange() {
    return nullabilityChange;
  }

  public void setNullabilityChange(ColumnNullabilityChangeModel nullabilityChange) {
    this.nullabilityChange = nullabilityChange;
  }

  @Override
  public String getTemplatePath() {
    return "/alter/change_column_nullability.ftl";
  }

  public static ChangeNullabilityModel create(TableReferenceModel table, ColumnNullabilityChangeModel nullabilityChange) {
    ChangeNullabilityModel model = new ChangeNullabilityModel();
    model.setTable(table);
    model.nullabilityChange = nullabilityChange;
    return model;
  }
}
