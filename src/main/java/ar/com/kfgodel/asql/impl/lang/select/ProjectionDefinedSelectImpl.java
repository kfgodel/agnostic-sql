package ar.com.kfgodel.asql.impl.lang.select;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.select.ProjectionDefinedSelect;
import ar.com.kfgodel.asql.api.select.TableDefinedSelect;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.select.SelectModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tenpines on 23/09/15.
 */
public class ProjectionDefinedSelectImpl implements ProjectionDefinedSelect {

  private List<AgnosticConstruct> projections;

  @Override
  public SelectModel parseModel() {
    return SelectModel.create(parseExpressionModels());
  }

  private List<AgnosticModel> parseExpressionModels() {
    return projections.stream().map(AgnosticConstruct::parseModel).collect(Collectors.toList());
  }

  public static ProjectionDefinedSelectImpl create(List<AgnosticConstruct> projections) {
    ProjectionDefinedSelectImpl select = new ProjectionDefinedSelectImpl();
    select.projections = projections;
    return select;
  }

  @Override
  public TableDefinedSelect from(String... tableNames) {
    List<TableReference> tableReferences = Arrays.stream(tableNames)
      .map(TableReference::create)
      .collect(Collectors.toList());
    return TableDefinedSelectImpl.create(this, tableReferences);
  }
}
