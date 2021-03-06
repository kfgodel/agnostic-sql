package ar.com.kfgodel.asql.statements.vendors;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.sequences.Sequence;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Esta clase verifica que en los diferentes vendors, el select una secuencia se traduzca correctamente
 * Created by dario.garcia on 19/04/17.
 */
@RunWith(JavaSpecRunner.class)
public class SelectSequenceValueTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    describe("an agnostic statement translation", () -> {
      context().translated(() -> context().vendor().translate(context().construct()));

      describe("for a value selection from a sequence", () -> {
        context().construct(() -> Sequence.nextValueFor("secuencia"));

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "NEXT VALUE FOR secuencia");
          verifyTranslationsIsAsExpected();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "NEXT VALUE FOR secuencia");
          verifyTranslationsIsAsExpected();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "NEXT VALUE FOR secuencia");
          verifyTranslationsIsAsExpected();
        });

        it("generates an postgresql specific statement when vendor is postgresql", () -> {
          context().vendor(Vendor::postgresql);
          context().expectedTranslation(() -> "nextval('secuencia')");
          verifyTranslationsIsAsExpected();
        });
      });

    });

  }

  private void verifyTranslationsIsAsExpected() {
    assertThat(context().translated()).isEqualTo(context().expectedTranslation());
  }

}