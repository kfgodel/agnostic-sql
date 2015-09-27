package ar.com.kfgodel.asql.statements;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tenpines on 24/09/15.
 */
@RunWith(JavaSpecRunner.class)
public class SelectStatementTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {

        Asql asql = AsqlBuilder.create();

        describe("an agnostic select statement", ()->{
            context().vendor(() -> Vendor.ansi());

            it("can have its minimum form", ()->{
                AgnosticStatement select = asql.select(1);

                String translated = context().vendor().translate(select);

                assertThat(translated).isEqualTo("SELECT 1");
            });

            describe("from clause", ()->{

                it("may reference a set of tables", ()->{
                    AgnosticStatement select = asql.select(asql.column("column1")).from("table1", "table2");

                    String translated = context().vendor().translate(select);

                    assertThat(translated).isEqualTo("SELECT column1 FROM table1, table2");
                });

            });

            it("has a where clause to express predicates", ()->{
                AgnosticStatement select = asql.select(asql.column("column1"))
                        .from("table1")
                        .where(asql.column("column1").isEqualsTo(2));

                String translated = context().vendor().translate(select);

                assertThat(translated).isEqualTo("SELECT column1 FROM table1 WHERE column1 = 2");
            });
        });
    }
}
