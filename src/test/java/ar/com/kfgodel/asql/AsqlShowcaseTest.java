package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.alter.ChangeColumnStatement;
import ar.com.kfgodel.asql.api.alter.RemoveColumnStatement;
import ar.com.kfgodel.asql.api.delete.DeleteStatement;
import ar.com.kfgodel.asql.api.drop.DropStatement;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.api.vendors.Vendor;
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
        // Declared here to avoid repetition on every tests.
        AsqlBuilderImpl asql = AsqlBuilderImpl.create();

        describe("agnostic sql", () -> {

            describe("expresses an abstract sql statement that is vendor independent", () -> {

                context().statement(() ->
                        asql.alter("POSA_SEVERIDADES").adding(asql.column("estadoDeLiquidacion_id").typed(DataType.fk())
                        ));

                it("can be translated to ansi sql", () -> {
                    TemplateInterpreter ansiInterpreter = TemplateInterpreter.create(Vendor.ansi());

                    String translatedSql = ansiInterpreter.translate(context().statement());

                    assertThat(translatedSql).isEqualTo("ALTER TABLE POSA_SEVERIDADES ADD estadoDeLiquidacion_id bigint");
                });

                it("can be translated to concrete hsqldb sql", () -> {
                    TemplateInterpreter hsqlInterpreter = TemplateInterpreter.create(Vendor.hsqldb());

                    String translatedSql = hsqlInterpreter.translate(context().statement());

                    assertThat(translatedSql).isEqualTo("ALTER TABLE POSA_SEVERIDADES ADD COLUMN estadoDeLiquidacion_id bigint");
                });

                it("can be translated to sqlserver vendor sql", () -> {
                    TemplateInterpreter sqlserverInterpreter = TemplateInterpreter.create(Vendor.sqlserver());

                    String translatedSql = sqlserverInterpreter.translate(context().statement());

                    assertThat(translatedSql).isEqualTo("ALTER TABLE POSA_SEVERIDADES ADD estadoDeLiquidacion_id numeric(19,0)");
                });

            });

            describe("drop column", () -> {
                it("it is basically ansi for all vendors",()->{
                    RemoveColumnStatement statement = asql.alter("tableName").removing("columnName");

                    assertThat(TemplateInterpreter.create(Vendor.ansi()).translate(statement)).isEqualTo("ALTER TABLE tableName DROP COLUMN columnName");
                    assertThat(TemplateInterpreter.create(Vendor.sqlserver()).translate(statement)).isEqualTo("ALTER TABLE tableName DROP COLUMN columnName");
                    assertThat(TemplateInterpreter.create(Vendor.hsqldb()).translate(statement)).isEqualTo("ALTER TABLE tableName DROP COLUMN columnName");
                });
            });

            describe("alter column", () -> {
                it("it is basically ansi for all vendors",()->{
                    ChangeColumnStatement statement = asql.alter("tableName").changing(asql.column("columnName").typed(DataType.integer()));

                    assertThat(TemplateInterpreter.create(Vendor.ansi()).translate(statement)).isEqualTo("ALTER TABLE tableName ALTER COLUMN columnName integer");
                    assertThat(TemplateInterpreter.create(Vendor.sqlserver()).translate(statement)).isEqualTo("ALTER TABLE tableName ALTER COLUMN columnName numeric(19,0)");
                    assertThat(TemplateInterpreter.create(Vendor.hsqldb()).translate(statement)).isEqualTo("ALTER TABLE tableName ALTER COLUMN columnName integer");
                });
            });

            describe("create table", () -> {

                context().interpreter(() -> TemplateInterpreter.create(Vendor.ansi()));

                context().statement(() -> asql.create("POSA_ESTADO_DE_LIQUIDACION")
                        .withIdPk()
                        .adding(asql.column("momentoDeCreacion").typed(DataType.timestamp()),
                                asql.column("momentoDeUltimaModificacion").typed(DataType.timestamp()),
                                asql.column("persistenceVersion").typed(DataType.bigInteger()),
                                asql.column("diasPorLiquidar").typed(DataType.integer()).nonNullable(),
                                asql.column("estado").typed(DataType.shortString())
                        ));

                it("can be compactly expressed without id details", () -> {

                    String generatedSql = context().interpreter().translate(context().statement());

                    assertThat(generatedSql).isEqualTo("CREATE TABLE POSA_ESTADO_DE_LIQUIDACION (\n" +
                            "id bigint generated by default as identity (start with 1), \n" +
                            "momentoDeCreacion timestamp, \n" +
                            "momentoDeUltimaModificacion timestamp, \n" +
                            "persistenceVersion bigint, \n" +
                            "diasPorLiquidar integer NOT NULL, \n" +
                            "estado VARCHAR(255), \n" +
                            "PRIMARY KEY (id)\n" +
                            ")");
                });

                it("even for different vendor id definition", () -> {
                    String generatedSql = TemplateInterpreter.create(Vendor.sqlserver()).translate(context().statement());

                    assertThat(generatedSql).isEqualTo("CREATE TABLE POSA_ESTADO_DE_LIQUIDACION (\n" +
                            "id numeric(19,0) identity, \n" +
                            "momentoDeCreacion datetime, \n" +
                            "momentoDeUltimaModificacion datetime, \n" +
                            "persistenceVersion numeric(19,0), \n" +
                            "diasPorLiquidar numeric(19,0) NOT NULL, \n" +
                            "estado VARCHAR(255), \n" +
                            "PRIMARY KEY (id)\n" +
                            ")");

                });
            });

            describe("drop table", () -> {
                it("it is basically ansi for all vendors",()->{
                    DropStatement statement = asql.drop("tableName");

                    assertThat(TemplateInterpreter.create(Vendor.ansi()).translate(statement)).isEqualTo("DROP TABLE tableName");
                    assertThat(TemplateInterpreter.create(Vendor.sqlserver()).translate(statement)).isEqualTo("DROP TABLE tableName");
                    assertThat(TemplateInterpreter.create(Vendor.hsqldb()).translate(statement)).isEqualTo("DROP TABLE tableName");
                });
            });


            describe("updates", () -> {

                context().interpreter(() -> TemplateInterpreter.create(Vendor.ansi()));

                it("without 'where' clause are expressed naturally ", () -> {
                    AgnosticStatement statement = asql.update("POSA_EMPLEADOS").set(asql.column("CATEGORIA_ID").to(1), asql.column("CATEGORIA_VAL").to("AA"));

                    String generatedSql = context().interpreter().translate(statement);

                    assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID = 1 , CATEGORIA_VAL = 'AA'");
                });

                it("can be used in multiple statements", () -> {
                    TableDefinedUpdate updateEmpleados = asql.update("POSA_EMPLEADOS");

                    AgnosticStatement firstStatement = updateEmpleados.set(asql.column("CATEGORIA_ID").to(1)).where(asql.column("CATEGORIA_ID").isNull());
                    AgnosticStatement secondStatement = updateEmpleados.set(asql.column("NOMBRE").to("Pepe")).where(asql.column("CATEGORIA_ID").isNotNull());

                    String generatedSql = context().interpreter().translate(Lists.newArrayList(firstStatement.parseModel(), secondStatement.parseModel()));

                    assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID = 1 WHERE CATEGORIA_ID IS NULL;\n" +
                            "UPDATE POSA_EMPLEADOS SET NOMBRE = 'Pepe' WHERE CATEGORIA_ID IS NOT NULL");
                });

            });

            describe("deletes", () -> {
                it("it is basically ansi for all vendors",()->{
                    DeleteStatement statement = asql.deleteFrom("tableName");

                    assertThat(TemplateInterpreter.create(Vendor.ansi()).translate(statement)).isEqualTo("DELETE FROM tableName");
                    assertThat(TemplateInterpreter.create(Vendor.sqlserver()).translate(statement)).isEqualTo("DELETE FROM tableName");
                    assertThat(TemplateInterpreter.create(Vendor.hsqldb()).translate(statement)).isEqualTo("DELETE FROM tableName");
                });   
            });


        });

    }
}