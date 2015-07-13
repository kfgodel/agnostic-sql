package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.api.Vendor;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.impl.AsqlBuilderImpl;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
import com.google.common.collect.Lists;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 11/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class AsqlShowcaseTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {

        describe("agnostic sql", () -> {
            
            it("expresses a sql statement that can be translated to different vendors", () -> {

            });

            describe("with ansi as the base definition", () -> {

                context().interpreter(() -> TemplateInterpreter.create(Vendor.ansi()));

                describe("updates", () -> {

                    it("without 'where' clause are expressed naturally ", () -> {
                        AsqlBuilder asql = AsqlBuilderImpl.create();

                        AgnosticStatement statement = asql.update("POSA_EMPLEADOS").set(asql.column("CATEGORIA_ID").to(1), asql.column("CATEGORIA_VAL").to("AA"));

                        String generatedSql = context().interpreter().translate(statement.parseModel());

                        assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID = 1 , CATEGORIA_VAL = 'AA'");
                    });

                    it("can be used in multiple statements", () -> {
                        AsqlBuilder asql = AsqlBuilderImpl.create();

                        TableDefinedUpdate updateEmpleados = asql.update("POSA_EMPLEADOS");

                        AgnosticStatement firstStatement = updateEmpleados.set(asql.column("CATEGORIA_ID").to(1)).where(asql.column("CATEGORIA_ID").isNull());
                        AgnosticStatement secondStatement = updateEmpleados.set(asql.column("NOMBRE").to("Pepe")).where(asql.column("CATEGORIA_ID").isNotNull());

                        String generatedSql = context().interpreter().translate(Lists.newArrayList(firstStatement.parseModel(), secondStatement.parseModel()));

                        assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID = 1 WHERE CATEGORIA_ID IS NULL;\n" +
                                "UPDATE POSA_EMPLEADOS SET NOMBRE = 'Pepe' WHERE CATEGORIA_ID IS NOT NULL");
                    });

                });


            });

        });



    }
}