package ar.com.kfgodel.asql.model;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.model.drop.DropModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 15/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class DropModelTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    describe("an agnostic drop table statement", () -> {

      context().model(() -> DropModel.create(TableReferenceModel.create("tableName")));

      it("can be translated to another vendor specific statement", () -> {
        VendorInterpreter interpreter = Vendor.ansi().getInterpreter();

        String translatedSql = interpreter.translate(context().model());

        assertThat(translatedSql).isEqualTo("DROP TABLE tableName");
      });

    });

  }
}