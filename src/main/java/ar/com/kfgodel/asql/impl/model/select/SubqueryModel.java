package ar.com.kfgodel.asql.impl.model.select;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * Created by tenpines on 23/09/15.
 */
public class SubqueryModel implements AgnosticModel {

  private AgnosticModel query;

  public AgnosticModel getQuery() {
    return query;
  }

  @Override
  public String getTemplatePath() {
    return "/operands/_subQuery.ftl";
  }

  public static SubqueryModel create(AgnosticModel query) {
    SubqueryModel model = new SubqueryModel();
    model.query = query;
    return model;
  }

}
