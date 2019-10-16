package ar.com.kfgodel.asql.impl.lang.create;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.create.ColumnDefinedCreate;
import ar.com.kfgodel.asql.api.create.CreateStatement;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.PkDefinitionModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import com.google.common.collect.Lists;

/**
 * Created by kfgodel on 14/07/15.
 */
public class PkDefinedCreateImpl implements ColumnDefinedCreate {
  private CreateStatement previous;

  @Override
  public ColumnDefinedCreate adding(ColumnDeclaration... declarations) {
    return ColumnDefinedCreateImpl.create(this, declarations);
  }

  @Override
  public CreateModel parseModel() {
    CreateModel createModel = previous.parseModel();

    ColumnReferenceModel pkColumn = ColumnReferenceModel.create("id");
    createModel.addDeclaration(ColumnDeclarationModel.create(pkColumn, DataType.pk().parseModel()));

    PkDefinitionModel pkDefinitionModel = PkDefinitionModel.create(Lists.newArrayList(pkColumn));
    createModel.addConstraint(ConstraintDeclarationModel.create(pkDefinitionModel));
    return createModel;
  }

  public static PkDefinedCreateImpl create(CreateStatement previousDefinition) {
    PkDefinedCreateImpl pkDefinedCreate = new PkDefinedCreateImpl();
    pkDefinedCreate.previous = previousDefinition;
    return pkDefinedCreate;
  }

}
