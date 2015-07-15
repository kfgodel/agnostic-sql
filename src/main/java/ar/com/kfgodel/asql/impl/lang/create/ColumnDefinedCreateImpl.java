package ar.com.kfgodel.asql.impl.lang.create;

import ar.com.kfgodel.asql.api.columns.ColumnDeclaration;
import ar.com.kfgodel.asql.api.create.ColumnDefinedCreate;
import ar.com.kfgodel.asql.api.create.CreateStatement;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;

/**
 * Created by kfgodel on 14/07/15.
 */
public class ColumnDefinedCreateImpl implements ColumnDefinedCreate {

    private CreateStatement previousDefinition;
    private ColumnDeclaration[] columns;

    @Override
    public ColumnDefinedCreate adding(ColumnDeclaration... declarations) {
        return ColumnDefinedCreateImpl.create(this, declarations);
    }

    @Override
    public CreateModel parseModel() {
        CreateModel createModel = previousDefinition.parseModel();
        for (ColumnDeclaration column : columns) {
            ColumnDeclarationModel columnModel = column.parseModel();
            createModel.addDeclaration(columnModel);
        }
        return createModel;
    }

    public static ColumnDefinedCreateImpl create(CreateStatement previousDefinition, ColumnDeclaration...declarations) {
        ColumnDefinedCreateImpl columnDefinedCreateImpl = new ColumnDefinedCreateImpl();
        columnDefinedCreateImpl.previousDefinition = previousDefinition;
        columnDefinedCreateImpl.columns = declarations;
        return columnDefinedCreateImpl;
    }

}
