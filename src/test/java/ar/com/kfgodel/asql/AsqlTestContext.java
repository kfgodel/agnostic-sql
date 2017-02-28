package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.contexts.TestContext;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.alter.AddColumnModel;
import ar.com.kfgodel.asql.impl.model.alter.RemoveColumnModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
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

    Vendor vendor();
    void vendor(Supplier<Vendor> definition);

    CreateModel createModel();
    void createModel(Supplier<CreateModel> definition);

    Asql asql();
    void asql(Supplier<Asql> definition);

    AddColumnModel addModel();
    void addModel(Supplier<AddColumnModel> definition);

    RemoveColumnModel removeModel();
    void removeModel(Supplier<RemoveColumnModel> definition);

    AgnosticModel model();
    void model(Supplier<AgnosticModel> definition);

    QueryCondition condition();
    void condition(Supplier<QueryCondition> definition);

    String translated();
    void translated(Supplier<String> definition);

    String expectedTranslation();

    void expectedTranslation(Supplier<String> definition);

}
