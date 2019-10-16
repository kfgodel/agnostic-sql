package ar.com.kfgodel.asql.model;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.model.alter.AddColumnModel;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
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

      context().addModel(() -> AddColumnModel.create(TableReferenceModel.create("tableName"), ColumnDeclarationModel.create(ColumnReferenceModel.create("columnName"), DataType.integer().parseModel())));

      it("can be translated to another vendor specific statement", () -> {
        VendorInterpreter interpreter = Vendor.ansi().getInterpreter();

        String translatedSql = interpreter.translate(context().addModel());

        assertThat(translatedSql).isEqualTo("ALTER TABLE tableName ADD columnName INTEGER");
      });

    });

  }
}