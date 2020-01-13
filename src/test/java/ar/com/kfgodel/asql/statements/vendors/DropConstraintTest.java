package ar.com.kfgodel.asql.statements.vendors;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies that the translation for each vendor is correct when droping a constraint
 * Created by dario.garcia on 16/03/17.
 */
@RunWith(JavaSpecRunner.class)
public class DropConstraintTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      context().translated(() -> context().vendor().translate(context().statement()));

      describe("for a contraint deletion ", () -> {
        context().statement(() -> asql.alter("tabla").removing(asql.constraint("constrenida")));

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "ALTER TABLE tabla DROP CONSTRAINT constrenida");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "ALTER TABLE tabla DROP CONSTRAINT constrenida");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "ALTER TABLE tabla DROP CONSTRAINT constrenida");
          verifyTranslationsIsAsExpected();
        });

        it("generates a postgresql specific statement when vendor is postgresql", () -> {
          context().vendor(Vendor::postgresql);
          context().expectedTranslation(() -> "ALTER TABLE tabla DROP CONSTRAINT constrenida");
          verifyTranslationsIsAsExpected();
        });
      });

    });

  }

  private void verifyTranslationsIsAsExpected() {
    assertThat(context().translated()).isEqualTo(context().expectedTranslation());
  }

}