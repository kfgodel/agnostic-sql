package ar.com.kfgodel.asql.impl.lang.create;

import ar.com.kfgodel.asql.api.DataType;
import ar.com.kfgodel.asql.api.create.ColumnDeclaration;
import ar.com.kfgodel.asql.api.create.ColumnDefinedCreate;
import ar.com.kfgodel.asql.api.create.CreateStatement;
import ar.com.kfgodel.asql.impl.model.create.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.create.TableConstraintModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class PkDefinedCreateImpl implements ColumnDefinedCreate {
    private CreateStatement previous;

    @Override
    public ColumnDefinedCreate with(ColumnDeclaration... declarations) {
        return ColumnDefinedCreateImpl.create(this, declarations);
    }

    @Override
    public CreateModel parseModel() {
        CreateModel createModel = previous.parseModel();
        createModel.addDeclaration(ColumnDeclarationModel.create("id", DataType.pk()));
        createModel.addConstraint(TableConstraintModel.create("PRIMARY KEY (id)"));
        return createModel;
    }

    public static PkDefinedCreateImpl create(CreateStatement previousDefinition) {
        PkDefinedCreateImpl pkDefinedCreate = new PkDefinedCreateImpl();
        pkDefinedCreate.previous = previousDefinition;
        return pkDefinedCreate;
    }

}
