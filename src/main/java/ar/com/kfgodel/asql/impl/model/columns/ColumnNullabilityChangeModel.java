package ar.com.kfgodel.asql.impl.model.columns;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

/**
 * Created by dario.garcia on 28/02/17.
 */
public class ColumnNullabilityChangeModel implements AgnosticModel {

  private ColumnReferenceModel column;
  private AgnosticModel columnType;
  private NullabilityModel nullability;

  public ColumnReferenceModel getColumn() {
    return column;
  }

  public void setColumn(ColumnReferenceModel column) {
    this.column = column;
  }

  public AgnosticModel getColumnType() {
    return columnType;
  }

  public void setColumnType(AgnosticModel columnType) {
    this.columnType = columnType;
  }

  public NullabilityModel getNullability() {
    return nullability;
  }

  public void setNullability(NullabilityModel nullability) {
    this.nullability = nullability;
  }

  @Override
  public String getTemplatePath() {
    return "/columns/_columnNullabilityModification.ftl";
  }

  public static ColumnNullabilityChangeModel create(ColumnReferenceModel columnReference, AgnosticModel columnType, NullabilityModel nullabilityModel) {
    ColumnNullabilityChangeModel model = new ColumnNullabilityChangeModel();
    model.column = columnReference;
    model.columnType = columnType;
    model.nullability = nullabilityModel;
    return model;
  }

}
