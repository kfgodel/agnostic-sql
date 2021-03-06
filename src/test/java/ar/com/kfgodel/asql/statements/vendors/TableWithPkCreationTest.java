package ar.com.kfgodel.asql.statements.vendors;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Esta clase verifica la creacion de tablas con columna PK para varias tablas
 * Created by dario.garcia on 06/03/17.
 */
@RunWith(JavaSpecRunner.class)
public class TableWithPkCreationTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      context().translated(() -> context().vendor().translate(context().statement()));

      describe("for a table creation with a pk column", () -> {
        context().statement(() -> asql.createTable("tabla").with(asql.column("columna").typed(DataType.pk())));

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT PRIMARY KEY NOT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT PRIMARY KEY NOT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT PRIMARY KEY NOT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

        it("generates an postgresql specific statement when vendor is postgresql", () -> {
          context().vendor(Vendor::postgresql);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT PRIMARY KEY\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

      });

    });

  }

  private void verifyTranslationsIsAsExpected() {
    assertThat(context().translated()).isEqualTo(context().expectedTranslation());
  }

}