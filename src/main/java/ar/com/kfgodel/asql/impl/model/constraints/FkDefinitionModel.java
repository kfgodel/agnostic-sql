package ar.com.kfgodel.asql.impl.model.constraints;

import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;

import java.util.List;

/**
 * Created by tenpines on 22/09/15.
 */
public class FkDefinitionModel implements ConstraintDefinitionModel {

  private List<ColumnReferenceModel> columns;
  private TableReferenceModel referencedTable;

  public List<ColumnReferenceModel> getColumns() {
    return columns;
  }

  public TableReferenceModel getReferencedTable() {
    return referencedTable;
  }

  @Override
  public String getTemplatePath() {
    return "/constraints/_fkDefinition.ftl";
  }

  public static FkDefinitionModel create(List<ColumnReferenceModel> columns, TableReferenceModel table) {
    FkDefinitionModel model = new FkDefinitionModel();
    model.columns = columns;
    model.referencedTable = table;
    return model;
  }

}
