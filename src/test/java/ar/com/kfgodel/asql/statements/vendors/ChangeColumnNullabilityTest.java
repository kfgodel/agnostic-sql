package ar.com.kfgodel.asql.statements.vendors;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
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
      when(() -> {
        context().translated(() -> context().vendor().translate(context().statement()));
      });
      then(() -> {
        assertThat(context().translated()).isEqualTo(context().expectedTranslation());
      });

      describe("for a column made nullable", () -> {
        given(() -> {
          context().statement(() -> asql.alter("tabla").changing(asql.column("columna").typed(DataType.bigInteger())).toNullable());
        });

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna BIGINT NULL");
          executeAsGivenWhenThenTest();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna SET NULL");
          executeAsGivenWhenThenTest();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna NUMERIC(19,0) NULL");
          executeAsGivenWhenThenTest();
        });
      });

      describe("for a column made non nullable", () -> {
        given(() -> {
          context().statement(() -> asql.alter("tabla").changing(asql.column("columna").typed(DataType.bigInteger())).toNonNullable());
        });

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna BIGINT NOT NULL");
          executeAsGivenWhenThenTest();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna SET NOT NULL");
          executeAsGivenWhenThenTest();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "ALTER TABLE tabla ALTER COLUMN columna NUMERIC(19,0) NOT NULL");
          executeAsGivenWhenThenTest();
        });
      });


    });

  }


}