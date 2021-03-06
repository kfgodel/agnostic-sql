package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.update.RestrictedUpdate;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;

/**
 * Created by kfgodel on 12/07/15.
 */
public class RestrictedUpdateImpl implements RestrictedUpdate {

  private UnrestrictedUpdateImpl unrestrictedUpdate;
  private AgnosticConstruct condition;

  @Override
  public UpdateModel parseModel() {
    UpdateModel updateModel = unrestrictedUpdate.parseModel();
    updateModel.getWhereClause().setPredicate(condition.parseModel());
    return updateModel;
  }

  public static RestrictedUpdateImpl create(UnrestrictedUpdateImpl unrestrictedUpdate, AgnosticConstruct condition) {
    RestrictedUpdateImpl update = new RestrictedUpdateImpl();
    update.condition = condition;
    update.unrestrictedUpdate = unrestrictedUpdate;
    return update;
  }

}
