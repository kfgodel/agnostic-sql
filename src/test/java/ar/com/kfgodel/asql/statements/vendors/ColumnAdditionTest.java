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
 * This type verifies that the translation for each vendor is correct when adding a new column to an existing table
 * Created by dario.garcia on 28/02/17.
 */
@RunWith(JavaSpecRunner.class)
public class ColumnAdditionTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      context().translated(() -> context().vendor().translate(context().statement()));

      describe("for a colunm addition ", () -> {
        context().statement(() -> asql.alter("tabla").adding(asql.column("columna").typed(DataType.booleanic()).defaultedTo(false).nonNullable()));

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "ALTER TABLE tabla ADD columna BOOLEAN NOT NULL DEFAULT false");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "ALTER TABLE tabla ADD columna BOOLEAN DEFAULT false NOT NULL");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "ALTER TABLE tabla ADD columna BIT NOT NULL DEFAULT false");
          verifyTranslationsIsAsExpected();
        });

        it("generates a postgresql specific statement when vendor is postgresql", () -> {
          context().vendor(Vendor::postgresql);
          context().expectedTranslation(() -> "ALTER TABLE tabla ADD columna BOOLEAN NOT NULL DEFAULT false");
          verifyTranslationsIsAsExpected();
        });
      });

    });

  }

  private void verifyTranslationsIsAsExpected() {
    assertThat(context().translated()).isEqualTo(context().expectedTranslation());
  }


}