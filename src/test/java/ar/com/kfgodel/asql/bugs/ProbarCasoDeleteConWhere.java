package ar.com.kfgodel.asql.bugs;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dario.garcia on 26/04/17.
 */
@RunWith(JavaSpecRunner.class)
public class ProbarCasoDeleteConWhere extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    AsqlBuilder asql = AsqlBuilder.create();
    xit("deberia andar",()->{
      String traducido = Vendor.ansi().translate(
        asql.deleteFrom("P10_ROLES_P10_PERMISOS")
          .where(
            asql.column("PERMISOS_ID").isEqualTo(
              asql.select(asql.column("ID")).from("P10_PERMISOS").where(asql.column("NOMBREINTERNO").isEqualTo("un permiso"))
            )
          )
      );
      assertThat(traducido).isEqualTo("DELETE FROM P10_ROLES_P10_PERMISOS WHERE PERMISOS_ID = '1'");
    });
  }
}