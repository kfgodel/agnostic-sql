package ar.com.kfgodel.asql.model;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.model.alter.RemoveColumnModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 15/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class RemoveColumnModelTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    describe("an agnostic remove column statement", () -> {

      context().removeModel(() -> RemoveColumnModel.create(TableReferenceModel.create("tableName"), ColumnReferenceModel.create("columnName")));

      it("can be translated to a vendor specific statement", () -> {
        VendorInterpreter interpreter = Vendor.ansi().getInterpreter();

        String translatedSql = interpreter.translate(context().removeModel());

        assertThat(translatedSql).isEqualTo("ALTER TABLE tableName DROP COLUMN columnName");
      });


    });

  }
}