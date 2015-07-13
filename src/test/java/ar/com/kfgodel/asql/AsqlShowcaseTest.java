package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.asql.api.AStatement;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.impl.AsqlBuilderImpl;
import com.google.common.collect.Lists;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 11/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class AsqlShowcaseTest extends JavaSpec<TestContext> {
    @Override
    public void define() {

        describe("agnostic sql", () -> {

            describe("for updating rows", () -> {

                it("can be used in multiple statements",()->{
                    AsqlBuilder asql = AsqlBuilderImpl.create();

                    TableDefinedUpdate updateEmpleados = asql.update("POSA_EMPLEADOS");

                    AStatement firstStatement = updateEmpleados.set("CATEGORIA_ID").to(1).where(asql.column("CATEGORIA_ID").isNull());
                    AStatement secondStatement = updateEmpleados.set("NOMBRE").to("Pepe").where(asql.column("CATEGORIA_ID").isNotNull());

                    String generatedSql = Asql.sqlserver().translate(Lists.newArrayList(firstStatement, secondStatement));

                    assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID = 1 WHERE CATEGORIA_ID IS NULL;\n" +
                            "UPDATE POSA_EMPLEADOS SET NOMBRE = 'Pepe' WHERE CATEGORIA_ID IS NOT NULL");
                });

                it("can be used for sqlserver", () -> {

                    AsqlBuilder asql = AsqlBuilderImpl.create();

                    AStatement statement = asql.update("POSA_EMPLEADOS").set("CATEGORIA_ID").to(1).where(asql.column("CATEGORIA_ID").isNull());

                    String generatedSql = Asql.sqlserver().translate(statement);

                    assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID=1 WHERE CATEGORIA_ID IS NULL");
                });

            });

        });



    }
}