package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.alter.ChangeColumnStatement;
import ar.com.kfgodel.asql.api.alter.RemoveColumnStatement;
import ar.com.kfgodel.asql.api.delete.RestrictedDeleteStatement;
import ar.com.kfgodel.asql.api.drop.DropStatement;
import ar.com.kfgodel.asql.api.functions.Function;
import ar.com.kfgodel.asql.api.indices.CreateIndexStatement;
import ar.com.kfgodel.asql.api.indices.DropIndexStatement;
import ar.com.kfgodel.asql.api.insert.InsertStatement;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 11/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class AsqlShowcaseTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {
        // Declared here to avoid repetition on every test
        Asql asql = AsqlBuilder.create();

        describe("agnostic sql", () -> {

            describe("expresses sql statements vendor independently", () -> {

                context().statement(() ->
                        asql.alter("tableName").adding(asql.column("columnName").typed(DataType.fk())
                        ));

                it("can be translated to ansi sql", () -> {
                    Vendor ansi = Vendor.ansi();

                    String translatedSql = ansi.translate(context().statement());

                    assertThat(translatedSql).isEqualTo("ALTER TABLE tableName ADD columnName bigint");
                });

                it("can be translated to hsqldb sql", () -> {
                    Vendor hsqldb = Vendor.hsqldb();

                    String translatedSql = hsqldb.translate(context().statement());

                    assertThat(translatedSql).isEqualTo("ALTER TABLE tableName ADD COLUMN columnName bigint");
                });

                it("can be translated to sqlserver vendor sql", () -> {
                    Vendor sqlserver = Vendor.sqlserver();

                    String translatedSql = sqlserver.translate(context().statement());

                    assertThat(translatedSql).isEqualTo("ALTER TABLE tableName ADD columnName numeric(19,0)");
                });

            });

            describe("column rename", ()->{

                context().statement(()-> asql.alter("tableName")
                        .renaming(asql.column("previousName"))
                        .to("newName")
                );

                it("is translated to standard sql for hsql", () -> {
                    String translated = Vendor.hsqldb().translate(context().statement());

                    assertThat(translated).isEqualTo("ALTER TABLE tableName ALTER COLUMN previousName RENAME TO newName");
                });

                it("is translated to a SP for sqlserver", ()->{
                    String translated = Vendor.sqlserver().translate(context().statement());

                    assertThat(translated).isEqualTo("EXEC sp_RENAME '[tableName].[previousName]','newName','COLUMN'");
                });

            });

            describe("select", ()->{
                context().vendor(() -> Vendor.ansi());

                it("can have its minimum form", ()->{
                    AgnosticStatement select = asql.select(1);

                    String translated = context().vendor().translate(select);

                    assertThat(translated).isEqualTo("SELECT 1");
                });
            });

            describe("drop column", () -> {
                it("is basically ansi for all vendors",()->{
                    RemoveColumnStatement statement = asql.alter("tableName").removing("columnName");

                    assertThat(Vendor.ansi().translate(statement)).isEqualTo("ALTER TABLE tableName DROP COLUMN columnName");
                    assertThat(Vendor.sqlserver().translate(statement)).isEqualTo("ALTER TABLE tableName DROP COLUMN columnName");
                    assertThat(Vendor.hsqldb().translate(statement)).isEqualTo("ALTER TABLE tableName DROP COLUMN columnName");
                });
            });

            describe("alter column", () -> {
                it("is basically ansi for all vendors",()->{
                    ChangeColumnStatement statement = asql.alter("tableName").changing(asql.column("columnName").typed(DataType.integer()));

                    assertThat(Vendor.ansi().translate(statement)).isEqualTo("ALTER TABLE tableName ALTER COLUMN columnName integer");
                    assertThat(Vendor.sqlserver().translate(statement)).isEqualTo("ALTER TABLE tableName ALTER COLUMN columnName numeric(19,0)");
                    assertThat(Vendor.hsqldb().translate(statement)).isEqualTo("ALTER TABLE tableName ALTER COLUMN columnName integer");
                });
            });

            describe("create table", () -> {

                context().vendor(() -> Vendor.ansi());

                context().statement(() -> asql.createTable("tableName")
                        .withIdPk()
                        .adding(asql.column("momentoDeCreacion").typed(DataType.timestamp()),
                                asql.column("momentoDeUltimaModificacion").typed(DataType.timestamp()),
                                asql.column("persistenceVersion").typed(DataType.bigInteger()),
                                asql.column("diasPorLiquidar").typed(DataType.integer()).nonNullable(),
                                asql.column("estado").typed(DataType.shortString())
                        ));

                it("can be expressed with default pk column definition", () -> {

                    String generatedSql = context().vendor().translate(context().statement());

                    assertThat(generatedSql).isEqualTo("CREATE TABLE tableName (\n" +
                            "id bigint generated by default as identity (start with 1), \n" +
                            "momentoDeCreacion timestamp, \n" +
                            "momentoDeUltimaModificacion timestamp, \n" +
                            "persistenceVersion bigint, \n" +
                            "diasPorLiquidar integer NOT NULL, \n" +
                            "estado VARCHAR(255), \n" +
                            "PRIMARY KEY ( id )\n" +
                            ")");
                });

                it("even for different vendor pk definition", () -> {
                    String generatedSql = Vendor.sqlserver().translate(context().statement());

                    assertThat(generatedSql).isEqualTo("CREATE TABLE tableName (\n" +
                            "id numeric(19,0) identity, \n" +
                            "momentoDeCreacion datetime, \n" +
                            "momentoDeUltimaModificacion datetime, \n" +
                            "persistenceVersion numeric(19,0), \n" +
                            "diasPorLiquidar numeric(19,0) NOT NULL, \n" +
                            "estado VARCHAR(255), \n" +
                            "PRIMARY KEY ( id )\n" +
                            ")");

                });
            });

            describe("drop table", () -> {
                it("is basically ansi for all vendors",()->{
                    DropStatement statement = asql.dropTable("tableName");

                    assertThat(Vendor.ansi().translate(statement)).isEqualTo("DROP TABLE tableName");
                    assertThat(Vendor.sqlserver().translate(statement)).isEqualTo("DROP TABLE tableName");
                    assertThat(Vendor.hsqldb().translate(statement)).isEqualTo("DROP TABLE tableName");
                });
            });


            describe("insert", () -> {
                it("is basically ansi for all vendors",()->{
                    InsertStatement statement = asql.insertInto("tableName").setting(asql.column("column1").to(1),
                            asql.column("column2").to(Function.currentDate()));

                    assertThat(Vendor.ansi().translate(statement)).isEqualTo("INSERT INTO tableName ( column1, column2 ) VALUES ( 1, CURRENT_DATE )");
                    assertThat(Vendor.sqlserver().translate(statement)).isEqualTo("INSERT INTO tableName ( column1, column2 ) VALUES ( 1, getDate() )");
                    assertThat(Vendor.hsqldb().translate(statement)).isEqualTo("INSERT INTO tableName ( column1, column2 ) VALUES ( 1, CURRENT_DATE )");
                });

                it("has an alternative traditional form",()->{
                    InsertStatement statement = asql.insertInto("tableName").set("column1", "column2").to(1, Function.currentTime());

                    assertThat(Vendor.ansi().translate(statement)).isEqualTo("INSERT INTO tableName ( column1, column2 ) VALUES ( 1, CURRENT_TIME )");
                });
            });


            describe("updates", () -> {

                context().vendor(() -> Vendor.ansi());

                it("without 'where' clause are expressed naturally ", () -> {
                    AgnosticStatement statement = asql.update("POSA_EMPLEADOS").setting(asql.column("CATEGORIA_ID").to(1), asql.column("CATEGORIA_VAL").to("AA"));

                    String generatedSql = context().vendor().translate(statement);

                    assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID = 1 , CATEGORIA_VAL = 'AA'");
                });

                it("can be partially used in multiple statements", () -> {
                    TableDefinedUpdate updateEmpleados = asql.update("POSA_EMPLEADOS");

                    AgnosticStatement firstStatement = updateEmpleados.setting(asql.column("CATEGORIA_ID").to(1)).where(asql.column("CATEGORIA_ID").isNull());
                    AgnosticStatement secondStatement = updateEmpleados.setting(asql.column("NOMBRE").to("Pepe")).where(asql.column("CATEGORIA_ID").isNotNull());

                    String generatedSql = context().vendor().translate(asql.asScript(
                            firstStatement,
                            secondStatement
                    ));

                    assertThat(generatedSql)
                            .isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID = 1 WHERE CATEGORIA_ID IS NULL;\n" +
                                    "UPDATE POSA_EMPLEADOS SET NOMBRE = 'Pepe' WHERE CATEGORIA_ID IS NOT NULL");
                });

            });

            describe("deletes", () -> {
                it("it is basically ansi for all vendors", () -> {
                    RestrictedDeleteStatement statement = asql.deleteFrom("tableName")
                            .where(asql.column("column1").isNull().and(asql.column("column2").isNotNull()).or(asql.column("column3").isNotNull()));

                    assertThat(Vendor.ansi().translate(statement)).isEqualTo("DELETE FROM tableName WHERE column1 IS NULL AND column2 IS NOT NULL OR column3 IS NOT NULL");
                    assertThat(Vendor.sqlserver().translate(statement)).isEqualTo("DELETE FROM tableName WHERE column1 IS NULL AND column2 IS NOT NULL OR column3 IS NOT NULL");
                    assertThat(Vendor.hsqldb().translate(statement)).isEqualTo("DELETE FROM tableName WHERE column1 IS NULL AND column2 IS NOT NULL OR column3 IS NOT NULL");
                });

                it("can be restricted with a suquery", ()->{
                    RestrictedDeleteStatement statement = asql.deleteFrom("tableName")
                            .where(asql.select(true));

                    String translated = Vendor.ansi().translate(statement);

                    assertThat(translated)
                            .isEqualTo("DELETE FROM tableName WHERE ( SELECT TRUE )");
                });
            });

            describe("table constraints", ()->{
                describe("foreign key", () -> {
                    it("can be expressed naturally", () -> {
                        AgnosticStatement statement = asql.alter("tableName")
                                .adding(asql.constraint("constraintName")
                                        .fkFrom("columnName1", "columnName2").to("otherTableName"));

                        assertThat(Vendor.ansi().translate(statement))
                                .isEqualTo("ALTER TABLE tableName ADD CONSTRAINT constraintName FOREIGN KEY ( columnName1, columnName2 ) REFERENCES otherTableName");

                    });
                });

                describe("unique key", () -> {
                    it("can be expressed", () -> {
                        AgnosticStatement statement = asql.alter("tableName")
                                .adding(asql.constraint("constraintName")
                                        .uniqueFor("columnName1", "columnName2"));

                        assertThat(Vendor.ansi().translate(statement))
                                .isEqualTo("ALTER TABLE tableName ADD CONSTRAINT constraintName UNIQUE ( columnName1, columnName2 )");

                    });
                });

                describe("primary key", () -> {
                    it("can be expressed for a single column", () -> {
                        AgnosticStatement statement = asql.alter("tableName")
                                .adding(asql.constraint("constraintName")
                                        .pkFor("columnName1", "columnName2"));

                        assertThat(Vendor.ansi().translate(statement))
                                .isEqualTo("ALTER TABLE tableName ADD CONSTRAINT constraintName PRIMARY KEY ( columnName1, columnName2 )");

                    });
                });
            });

            describe("index", ()->{

                it("is created for columns", () -> {
                    CreateIndexStatement statement = asql.createIndex("anIndexName")
                            .on("tableName").forColumns("column1", "column2");

                    String translated = Vendor.ansi().translate(statement);

                    assertThat(translated).isEqualTo("CREATE INDEX anIndexName ON tableName (column1, column2)");
                });


                describe("drop", () -> {
                    it("is dropped from a table (for compatibility reasons)", () -> {
                        DropIndexStatement statement = asql.dropIndex("anIndexName")
                                .from("tableName");

                        String translated = Vendor.ansi().translate(statement);

                        assertThat(translated).isEqualTo("DROP INDEX anIndexName");
                    });

                    it("table is needed for sqlserver", () -> {
                        DropIndexStatement statement = asql.dropIndex("anIndexName")
                                .from("tableName");

                        String translated = Vendor.sqlserver().translate(statement);

                        assertThat(translated).isEqualTo("DROP INDEX tableName.anIndexName");
                    });
                });

            });

        });

    }
}