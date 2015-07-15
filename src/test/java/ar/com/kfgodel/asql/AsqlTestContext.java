package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.impl.model.add.AddColumnModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.remove.RemoveColumnModel;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;

import java.util.function.Supplier;

/**
 * This type represents the test context for asql tests
 * Created by kfgodel on 12/07/15.
 */
public interface AsqlTestContext extends TestContext {

    AgnosticStatement statement();
    void statement(Supplier<AgnosticStatement> definition);

    UpdateModel updateModel();
    void updateModel(Supplier<UpdateModel> definition);

    VendorInterpreter interpreter();
    void interpreter(Supplier<VendorInterpreter> definition);

    CreateModel createModel();
    void createModel(Supplier<CreateModel> definition);

    AsqlBuilder asql();
    void asql(Supplier<AsqlBuilder> definition);

    AddColumnModel addModel();
    void addModel(Supplier<AddColumnModel> definition);

    RemoveColumnModel removeModel();
    void removeModel(Supplier<RemoveColumnModel> definition);

}
