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
            asql.deleteFrom("P10_ROLES_P10_PERMISOS").where(
                asql.column("PERMISOS_ID").isEqualTo(asql.select(asql.column("ID")).from("P10_PERMISOS").where(asql.column("NOMBREINTERNO").isEqualTo("un permiso")))
                  .and(asql.column("columna").isEqualTo(2)
                )
              )
          );
        });

        it("generates a standard statement when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);
          context().expectedTranslation(() -> "DELETE FROM P10_ROLES_P10_PERMISOS WHERE PERMISOS_ID = ( SELECT ID FROM P10_PERMISOS WHERE NOMBREINTERNO = 'un permiso' ) AND columna = 2");
          executeAsGivenWhenThenTest();
        });

        it("generates an hsqldb specific statement when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);
          context().expectedTranslation(() -> "DELETE FROM P10_ROLES_P10_PERMISOS WHERE PERMISOS_ID = ( SELECT ID FROM P10_PERMISOS WHERE NOMBREINTERNO = 'un permiso' ) AND columna = 2");
          executeAsGivenWhenThenTest();
        });

        it("generates a sqlserver specific statement when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);
          context().expectedTranslation(() -> "DELETE FROM P10_ROLES_P10_PERMISOS WHERE PERMISOS_ID = ( SELECT ID FROM P10_PERMISOS WHERE NOMBREINTERNO = 'un permiso' ) AND columna = 2");
          executeAsGivenWhenThenTest();
        });
      });

    });

  }
}