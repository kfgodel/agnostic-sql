package ar.com.kfgodel.asql.statements.vendors;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Esta clase verifica que un delete con restricciones se traduzca correctamente a distintos vendors
 * Created by dario.garcia on 13/05/17.
 */
@RunWith(JavaSpecRunner.class)
public class RestrictedDeleteTest extends JavaSpec<AsqlTestContext> {
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

      describe("for a restricted deletion", () -> {
        given(() -> {
          context().statement(() ->
            asql.deleteFrom("P10_GRUPOS_P10_ROLES").where(asql.column("ROLES_ID").isIn(
              asql.select("ID")
                .from("P10_ROLES")
                .where(asql.column("NOMBRE").isEqualTo("Administrador de temas relacionados a beneficios y vouchers"))
            ))
          );
        });

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "DELETE FROM P10_GRUPOS_P10_ROLES WHERE ROLES_ID IN ( SELECT 'ID' FROM P10_ROLES WHERE NOMBRE = 'Administrador de temas relacionados a beneficios y vouchers' )");
          executeAsGivenWhenThenTest();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "DELETE FROM P10_GRUPOS_P10_ROLES WHERE ROLES_ID IN ( SELECT 'ID' FROM P10_ROLES WHERE NOMBRE = 'Administrador de temas relacionados a beneficios y vouchers' )");
          executeAsGivenWhenThenTest();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "DELETE FROM P10_GRUPOS_P10_ROLES WHERE ROLES_ID IN ( SELECT 'ID' FROM P10_ROLES WHERE NOMBRE = 'Administrador de temas relacionados a beneficios y vouchers' )");
          executeAsGivenWhenThenTest();
        });
      });

    });

  }
}