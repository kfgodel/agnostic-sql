package ar.com.kfgodel.asql.model;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.PkDefinitionModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.operators.NotOperatorModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;
import com.google.common.collect.Lists;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test verifies the behavior of a create model
 * Created by kfgodel on 13/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class CreateModelTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    describe("an agnostic create statement model", () -> {

      context().createModel(() -> {
        CreateModel createModel = CreateModel.create(TableReferenceModel.create("POSA_ESTADO_DE_LIQUIDACION"));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("id"), DataType.pk().parseModel()));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("momentoDeCreacion"), DataType.timestamp().parseModel()));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("momentoDeUltimaModificacion"), DataType.timestamp().parseModel()));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("persistenceVersion"), DataType.bigInteger().parseModel()));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("diasPorLiquidar"), DataType.integer().parseModel()).withNullability(NotOperatorModel.createPlacedBefore(Internal.nullRef().parseModel())));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("cantidad"), DataType.integer().parseModel()).withNullability(NotOperatorModel.createPlacedBefore(Internal.nullRef().parseModel())).withDefaultValue(ExplicitValueModel.create(0)));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("otra_id"), DataType.fk().parseModel()));
        createModel.addDeclaration(ColumnDeclarationModel.create(ColumnReferenceModel.create("estado"), DataType.shortString().parseModel()));
        createModel.addConstraint(ConstraintDeclarationModel.create(PkDefinitionModel.create(Lists.newArrayList(ColumnReferenceModel.create("id")))));
        return createModel;
      });

      it("can be translated to a vendor specific statement", () -> {

        VendorInterpreter interpreter = Vendor.ansi().getInterpreter();

        String translatedSql = interpreter.translate(context().createModel());

        assertThat(translatedSql).isEqualTo("CREATE TABLE POSA_ESTADO_DE_LIQUIDACION (\n" +
          "id BIGINT PRIMARY KEY NOT NULL, \n" +
          "momentoDeCreacion TIMESTAMP, \n" +
          "momentoDeUltimaModificacion TIMESTAMP, \n" +
          "persistenceVersion BIGINT, \n" +
          "diasPorLiquidar INTEGER NOT NULL, \n" +
          "cantidad INTEGER NOT NULL DEFAULT 0, \n" +
          "otra_id BIGINT, \n" +
          "estado VARCHAR(255), \n" +
          "PRIMARY KEY ( id )\n" +
          ")");
      });

      it("can be translated to another vendor specific statement", () -> {
        VendorInterpreter interpreter = Vendor.sqlserver().getInterpreter();

        String translatedSql = interpreter.translate(context().createModel());

        assertThat(translatedSql).isEqualTo("CREATE TABLE POSA_ESTADO_DE_LIQUIDACION (\n" +
          "id BIGINT PRIMARY KEY NOT NULL, \n" +
          "momentoDeCreacion DATETIME2, \n" +
          "momentoDeUltimaModificacion DATETIME2, \n" +
          "persistenceVersion BIGINT, \n" +
          "diasPorLiquidar INT NOT NULL, \n" +
          "cantidad INT NOT NULL DEFAULT 0, \n" +
          "otra_id BIGINT, \n" +
          "estado VARCHAR(255), \n" +
          "PRIMARY KEY ( id )\n" +
          ")");
      });

    });

  }
}