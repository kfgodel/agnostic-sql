package ar.com.kfgodel.asql.statements.vendors;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
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
      when(() -> {
        context().translated(() -> context().vendor().translate(context().statement()));
      });
      then(() -> {
        assertThat(context().translated()).isEqualTo(context().expectedTranslation());
      });

      describe("for a contraint deletion ", () -> {
        given(() -> {
          context().statement(() -> asql.alter("tabla").removing(asql.constraint("constrenida")));
        });

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "ALTER TABLE tabla DROP CONSTRAINT constrenida");
          executeAsGivenWhenThenTest();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "ALTER TABLE tabla DROP CONSTRAINT constrenida");
          executeAsGivenWhenThenTest();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "ALTER TABLE tabla DROP CONSTRAINT constrenida");
          executeAsGivenWhenThenTest();
        });
      });

    });

  }
}