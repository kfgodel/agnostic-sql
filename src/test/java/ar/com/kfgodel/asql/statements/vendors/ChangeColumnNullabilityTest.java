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
 * This type verifies that the transalation for each vendor is correct when creating a column with explicit nullability
 * Created by dario.garcia on 28/02/17.
 */
@RunWith(JavaSpecRunner.class)
public class ChangeColumnNullabilityTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      context().translated(() -> context().vendor().translate(context().statement()));

      describe("for a column made nullable", () -> {
        context().statement(() -> asql.alter("tabla").changing(asql.column("columna").typed(DataType.bigInteger())).toNullable());

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna BIGINT NULL");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna SET NULL");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna BIGINT NULL");
          verifyTranslationsIsAsExpected();
        });

        it("generates a postgresql specific statement when vendor is postgresql", () -> {
          context().vendor(Vendor::postgresql);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna SET NULL");
          verifyTranslationsIsAsExpected();
        });
      });

      describe("for a column made non nullable", () -> {
        context().statement(() -> asql.alter("tabla").changing(asql.column("columna").typed(DataType.bigInteger())).toNonNullable());

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna BIGINT NOT NULL");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna SET NOT NULL");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna BIGINT NOT NULL");
          verifyTranslationsIsAsExpected();
        });

        it("generates a postgresql specific statement when vendor is postgresql", () -> {
          context().vendor(Vendor::postgresql);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna SET NOT NULL");
          verifyTranslationsIsAsExpected();
        });
      });


    });

  }

  private void verifyTranslationsIsAsExpected() {
    assertThat(context().translated()).isEqualTo(context().expectedTranslation());
  }


}