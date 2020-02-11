package ar.com.kfgodel.asql.statements.vendors;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test verifies the behavior of agnostic queries for limited result queries
 * Created by tenpines on 24/09/15.
 */
@RunWith(JavaSpecRunner.class)
public class LimitedSelectStatementTest extends JavaSpec<AsqlTestContext> {
  @Override
  public void define() {
    Asql asql = AsqlBuilder.create();
    describe("an agnostic limited select translation", () -> {
      context().translated(()-> context().vendor().translate(context().statement()));

      describe("without a where clause", () -> {
        context().statement(()-> asql.select(asql.column("column1")).from("table1").limit(1));

        it("uses a fetch first clause at the end when vendor is ansi", () -> {
          context().vendor(Vendor::ansi);

          assertThat(context().translated()).isEqualTo("SELECT column1 FROM table1 FETCH FIRST 1 ROWS ONLY");
        });

        it("uses top after select keyword when vendor is sqlserver", () -> {
          context().vendor(Vendor::sqlserver);

          assertThat(context().translated()).isEqualTo("SELECT TOP 1 column1 FROM table1");
        });

        it("has a limit clause at the end when vendor is hsqldb", () -> {
          context().vendor(Vendor::hsqldb);

          assertThat(context().translated()).isEqualTo("SELECT column1 FROM table1 LIMIT 1");
        });

        it("has a limit clause at the end when vendor is postgreslq", () -> {
          context().vendor(Vendor::postgresql);

          assertThat(context().translated()).isEqualTo("SELECT column1 FROM table1 LIMIT 1");
        });
      });

      describe("with a where clause", () -> {
        context().statement(()-> asql.select(asql.column("column1"))
          .from("table1")
          .where(asql.column("column1").isEqualTo(2))
          .limit(1));

        it("adds the fetch first clause after the where clause for ansi", () -> {
          context().vendor(Vendor::ansi);

          assertThat(context().translated()).isEqualTo("SELECT column1 FROM table1 WHERE column1 = 2 FETCH FIRST 1 ROWS ONLY");
        });

        it("uses TOP clause after select keyword in for sqlserver", () -> {
          context().vendor(Vendor::sqlserver);

          assertThat(context().translated()).isEqualTo("SELECT TOP 1 column1 FROM table1 WHERE column1 = 2");
        });

        it("uses limit clause after where clause for hsqldb", () -> {
          context().vendor(Vendor::hsqldb);

          assertThat(context().translated()).isEqualTo("SELECT column1 FROM table1 WHERE column1 = 2 LIMIT 1");
        });

        it("uses limit clause after where clause for postgreslq", () -> {
          context().vendor(Vendor::postgresql);

          assertThat(context().translated()).isEqualTo("SELECT column1 FROM table1 WHERE column1 = 2 LIMIT 1");
        });

      });

      describe("used as subquery", () -> {
        context().statement(()->
          asql.update("tabla1").setting(asql.column("columna1").to(
              asql.select("columna2")
                .from("tabla2")
                .limit(1)
            ))
        );

        it("includes the fetch first clause inside subquery parenthesis for ansi", () -> {
          context().vendor(Vendor::ansi);

          assertThat(context().translated())
            .isEqualTo("UPDATE tabla1 SET columna1 = ( SELECT 'columna2' FROM tabla2 FETCH FIRST 1 ROWS ONLY )");
        });

        it("includes the TOP clause inside the subquery parenthesis for sqlserver", () -> {
          context().vendor(Vendor::sqlserver);

          assertThat(context().translated())
            .isEqualTo("UPDATE tabla1 SET columna1 = ( SELECT TOP 1 'columna2' FROM tabla2 )");
        });

        it("includes the limit clause inside the subquery parenthesis for hsqldb", () -> {
          context().vendor(Vendor::hsqldb);

          assertThat(context().translated())
            .isEqualTo("UPDATE tabla1 SET columna1 = ( SELECT 'columna2' FROM tabla2 LIMIT 1 )");
        });

        it("includes the limit clause inside the subquery parenthesis for postgresql", () -> {
          context().vendor(Vendor::postgresql);

          assertThat(context().translated())
            .isEqualTo("UPDATE tabla1 SET columna1 = ( SELECT 'columna2' FROM tabla2 LIMIT 1 )");
        });

      });
    });
  }
}
