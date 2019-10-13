package ar.com.kfgodel.asql.statements.vendors;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class verifies that custom sql doesn't get translated for any vendor
 * Created by dario.garcia on 19/04/17.
 */
@RunWith(JavaSpecRunner.class)
public class CustomConstructTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      context().translated(() -> context().vendor().translate(context().statement()));

      describe("for a value selection from a sequence", () -> {
        context().statement(() -> asql.customSql("I'm custom made"));

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "I'm custom made");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "I'm custom made");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "I'm custom made");
          verifyTranslationsIsAsExpected();
        });
      });

    });

  }

  private void verifyTranslationsIsAsExpected() {
    assertThat(context().translated()).isEqualTo(context().expectedTranslation());
  }

}