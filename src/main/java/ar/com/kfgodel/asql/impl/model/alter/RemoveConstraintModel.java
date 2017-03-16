package ar.com.kfgodel.asql.impl.model.alter;

import ar.com.kfgodel.asql.impl.model.references.ConstraintReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * This type represents the information needed to drop a constraint
 * Created by dario.garcia on 16/03/17.
 */
public class RemoveConstraintModel extends TableCenteredModel {

  private ConstraintReferenceModel constraint;

  public ConstraintReferenceModel getConstraint() {
    return constraint;
  }

  public void setConstraint(ConstraintReferenceModel constraint) {
    this.constraint = constraint;
  }

  public static RemoveConstraintModel create(TableReferenceModel table, ConstraintReferenceModel constraint) {
    RemoveConstraintModel model = new RemoveConstraintModel();
    model.setTable(table);
    model.constraint = constraint;
    return model;
  }

  @Override
  public String getTemplatePath() {
    return "/alter/remove_constraint.ftl";
  }

}
