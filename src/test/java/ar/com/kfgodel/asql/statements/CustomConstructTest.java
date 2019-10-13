package ar.com.kfgodel.asql.statements;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * this class verifies the composability of a custom construct with other statements
 * Created by dario.garcia on 19/04/17.
 */
@RunWith(JavaSpecRunner.class)
public class CustomConstructTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    Asql asql = AsqlBuilder.create();

    describe("an agnostic custom construct", () -> {
      context().customConstruct(()-> asql.customSql("any sql you want"));

      context().translated(()-> Vendor.ansi().translate(context().statement()));

      it("can be used on a projection",()->{
        context().statement(()-> asql.select(context().customConstruct()));
        assertThat(context().translated()).isEqualTo("SELECT any sql you want");
      });

      it("can be used on an typical insertion",()->{
        context().statement(()-> asql.insertInto("tabla").set("columna").to(context().customConstruct()));
        assertThat(context().translated()).isEqualTo("INSERT INTO tabla ( columna ) VALUES ( any sql you want )");
      });

      it("can be used on an improved insertion",()->{
        context().statement(()-> asql.insertInto("tabla").setting(asql.column("columna").to(context().customConstruct())));
        assertThat(context().translated()).isEqualTo("INSERT INTO tabla ( columna ) VALUES ( any sql you want )");
      });

    });

  }
}