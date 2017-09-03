package ar.com.kfgodel.asql.statements.vendors;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dario.garcia on 02/09/17.
 */
@RunWith(JavaSpecRunner.class)
public class CreateSequenceTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      when(() -> {
        context().translated(() -> context().vendor().translate(context().construct()));
      });
      then(() -> {
        assertThat(context().translated()).isEqualTo(context().expectedTranslation());
      });

      describe("for a value selection from a sequence", () -> {
        given(() -> {
          context().construct(() -> asql.createSequece("hibernate_sequence").startWith(20).incrementBy(1));
        });

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "CREATE SEQUENCE hibernate_sequence START WITH 20 INCREMENT BY 1");
          executeAsGivenWhenThenTest();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "CREATE SEQUENCE hibernate_sequence START WITH 20 INCREMENT BY 1");
          executeAsGivenWhenThenTest();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "CREATE SEQUENCE hibernate_sequence START WITH 20 INCREMENT BY 1");
          executeAsGivenWhenThenTest();
        });
      });

    });

  }
}