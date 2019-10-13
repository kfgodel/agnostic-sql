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
 * This type verifies that the translation for each vendor is correct when creating a column with explicit nullability
 * Created by dario.garcia on 28/02/17.
 */
@RunWith(JavaSpecRunner.class)
public class CreationWithNullabilityTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      context().translated(() -> context().vendor().translate(context().statement()));

      describe("for a table creation with a null column", () -> {
        context().statement(() -> asql.createTable("tabla").with(asql.column("columna").typed(DataType.bigInteger()).nullable()));

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });
      });

      describe("for a table creation with a non null column", () -> {
        context().statement(() -> asql.createTable("tabla").with(asql.column("columna").typed(DataType.bigInteger()).nonNullable()));

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT NOT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT NOT NULL\n" +
            ")");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "CREATE TABLE tabla (\n" +
            "columna BIGINT NOT NULL\n" +
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