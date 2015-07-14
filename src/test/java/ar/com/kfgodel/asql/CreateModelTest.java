package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.api.DataType;
import ar.com.kfgodel.asql.api.Vendor;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
import ar.com.kfgodel.asql.impl.model.create.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.create.TableConstraintModel;
import ar.com.kfgodel.asql.impl.value.ExplicitValueModel;
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

            context().createModel(()->{
                CreateModel createModel = CreateModel.create("POSA_ESTADO_DE_LIQUIDACION");
                createModel.addDeclaration(ColumnDeclarationModel.create("id",DataType.pk()));
                createModel.addDeclaration(ColumnDeclarationModel.create("momentoDeCreacion",DataType.timestamp()));
                createModel.addDeclaration(ColumnDeclarationModel.create("momentoDeUltimaModificacion",DataType.timestamp()));
                createModel.addDeclaration(ColumnDeclarationModel.create("persistenceVersion", DataType.bigint()));
                createModel.addDeclaration(ColumnDeclarationModel.create("diasPorLiquidar", DataType.integer()).withNullity("NOT NULL"));
                createModel.addDeclaration(ColumnDeclarationModel.create("cantidad",DataType.integer()).withNullity("NOT NULL").withDefaultValue(ExplicitValueModel.create(0)));
                createModel.addDeclaration(ColumnDeclarationModel.create("otra_id", DataType.fk()));
                createModel.addDeclaration(ColumnDeclarationModel.create("estado", DataType.shortString()));
                createModel.addConstraint(TableConstraintModel.create("primary key (id)"));
                return createModel;
            });

            it("can be translated to a vendor specific statement", () -> {

                VendorInterpreter interpreter = TemplateInterpreter.create(Vendor.ansi());

                String translatedSql = interpreter.translate(context().createModel());

                assertThat(translatedSql).isEqualTo("CREATE TABLE POSA_ESTADO_DE_LIQUIDACION (\n" +
                        "id bigint generated by default as identity (start with 1), \n" +
                        "momentoDeCreacion timestamp, \n" +
                        "momentoDeUltimaModificacion timestamp, \n" +
                        "persistenceVersion bigint, \n" +
                        "diasPorLiquidar integer NOT NULL, \n" +
                        "cantidad integer NOT NULL DEFAULT 0, \n" +
                        "otra_id bigint, \n" +
                        "estado VARCHAR(255), \n" +
                        "primary key (id)\n" +
                        ")");
            });
            
            it("can be translated to another vendor specific statement",()->{
                VendorInterpreter interpreter = TemplateInterpreter.create(Vendor.sqlserver());

                String translatedSql = interpreter.translate(context().createModel());

                assertThat(translatedSql).isEqualTo("CREATE TABLE POSA_ESTADO_DE_LIQUIDACION (\n" +
                        "id numeric(19,0) identity, \n" +
                        "momentoDeCreacion datetime, \n" +
                        "momentoDeUltimaModificacion datetime, \n" +
                        "persistenceVersion numeric(19,0), \n" +
                        "diasPorLiquidar numeric(19,0) NOT NULL, \n" +
                        "cantidad numeric(19,0) NOT NULL DEFAULT 0, \n" +
                        "otra_id numeric(19,0), \n" +
                        "estado VARCHAR(255), \n" +
                        "primary key (id)\n" +
                        ")");
            });   

        });

    }
}