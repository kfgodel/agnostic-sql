package ar.com.kfgodel.asql.model;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
import ar.com.kfgodel.asql.impl.model.alter.ChangeColumnModel;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 15/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class ChangeColumnModelTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {
        describe("an agnostic change column type model", () -> {
            context().model(() -> ChangeColumnModel.create("tableName", ColumnDeclarationModel.create(ColumnReferenceModel.create("columnName"), DataType.integer().parseModel())));

            it("can be translated to a vendor specific statement", () -> {
                VendorInterpreter interpreter = TemplateInterpreter.create(Vendor.ansi());

                String translatedSql = interpreter.translate(context().model());

                assertThat(translatedSql).isEqualTo("ALTER TABLE tableName ALTER COLUMN columnName integer");
            });

        });

    }
}