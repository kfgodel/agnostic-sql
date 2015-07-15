package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.api.DataType;
import ar.com.kfgodel.asql.api.Vendor;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
import ar.com.kfgodel.asql.impl.model.add.AddColumnModel;
import ar.com.kfgodel.asql.impl.model.create.ColumnDeclarationModel;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 14/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class AddColumnModelTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {
        describe("an agnostic add column model", () -> {

            context().addModel(() -> AddColumnModel.create("tableName", ColumnDeclarationModel.create("columnName", DataType.integer())));

            it("can be translated to another vendor specific statement", () -> {
                VendorInterpreter interpreter = TemplateInterpreter.create(Vendor.ansi());

                String translatedSql = interpreter.translate(context().addModel());

                assertThat(translatedSql).isEqualTo("ALTER TABLE tableName ADD columnName integer");
            });

        });

    }
}