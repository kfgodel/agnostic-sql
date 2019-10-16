package ar.com.kfgodel.asql.impl.model.columns;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.create.TablePartModel;
import ar.com.kfgodel.asql.impl.model.nullability.NullabilityModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

/**
 * This type represents the abstract model of a column declaration
 * Created by kfgodel on 13/07/15.
 */
public class ColumnDeclarationModel implements TablePartModel, AgnosticModel {

  private ColumnReferenceModel column;
  private AgnosticModel columnType;
  private NullabilityModel nullability;
  private Object defaultValue;

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

  public Object getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(Object defaultValue) {
    this.defaultValue = defaultValue;
  }

  @Override
  public String getTemplatePath() {
    return "/columns/_columnDeclaration.ftl";
  }

  public ColumnDeclarationModel withNullability(NullabilityModel nullity) {
    this.setNullability(nullity);
    return this;
  }

  public ColumnDeclarationModel withDefaultValue(Object defaultValue) {
    this.setDefaultValue(defaultValue);
    return this;
  }

  public static ColumnDeclarationModel create(ColumnReferenceModel columnReference, AgnosticModel columnType) {
    ColumnDeclarationModel model = new ColumnDeclarationModel();
    model.column = columnReference;
    model.columnType = columnType;
    return model;
  }
}
