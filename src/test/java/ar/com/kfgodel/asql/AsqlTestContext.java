package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.asql.impl.tree.UpdateModel;

import java.util.function.Supplier;

/**
 * This type represents the test context for asql tests
 * Created by kfgodel on 12/07/15.
 */
public interface AsqlTestContext extends TestContext {

    UpdateModel updateModel();
    void updateModel(Supplier<UpdateModel> definition);

}
