package ar.com.kfgodel.asql.statements;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.functions.Function;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
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

    describe("an agnostic select statement", () -> {
      context().vendor(() -> Vendor.ansi());

      it("can have its minimum form", () -> {
        AgnosticStatement select = asql.select(1);

        String translated = context().vendor().translate(select);

        assertThat(translated).isEqualTo("SELECT 1");
      });

      describe("from clause", () -> {

        it("may reference a set of tables", () -> {
          AgnosticStatement select = asql.select(asql.column("column1")).from("table1", "table2");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT column1 FROM table1, table2");
        });

      });

      it("has a where clause to express predicates", () -> {
        AgnosticStatement select = asql.select(asql.column("column1"))
          .from("table1")
          .where(asql.column("column1").isEqualTo(2));

        String translated = context().vendor().translate(select);

        assertThat(translated).isEqualTo("SELECT column1 FROM table1 WHERE column1 = 2");
      });

      describe("projections include", () -> {

        it("distinct columns", () -> {
          AgnosticStatement select = asql.select(Function.distinct(asql.column("column1"), asql.column("column2")))
            .from("table1");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT DISTINCT column1, column2 FROM table1");
        });

        it("count(*)", () -> {
          AgnosticStatement select = asql.select(Function.count())
            .from("table1");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT COUNT(*) FROM table1");
        });

        it("count specific column", () -> {
          AgnosticStatement select = asql.select(Function.count(asql.column("column1")))
            .from("table1");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT COUNT(column1) FROM table1");
        });

        it("maximum of a column", () -> {
          AgnosticStatement select = asql.select(Function.max(asql.column("column1")))
            .from("table1");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT MAX(column1) FROM table1");
        });

        it("minimum of a column", () -> {
          AgnosticStatement select = asql.select(Function.min(asql.column("column1")))
            .from("table1");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT MIN(column1) FROM table1");
        });

        it("sum of a column", () -> {
          AgnosticStatement select = asql.select(Function.sum(asql.column("column1")))
            .from("table1");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT SUM(column1) FROM table1");
        });

        it("average of a column", () -> {
          AgnosticStatement select = asql.select(Function.avg(asql.column("column1")))
            .from("table1");

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT AVG(column1) FROM table1");
        });


      });
    });

    describe("limit clause", () -> {

      describe("simple select", () -> {
        AgnosticStatement select = asql.select(asql.column("column1")).from("table1").limit(1);

        it("has a top clause in the beginning in ansi", () -> {
          context().vendor(Vendor::ansi);

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT TOP 1 column1 FROM table1");
        });

        it("has a top clause in the end of the statement in postgreslq", () -> {
          context().vendor(Vendor::postgresql);

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT column1 FROM table1 limit 1");
        });
      });

      describe("select with where", () -> {
        AgnosticStatement select = asql.select(asql.column("column1"))
          .from("table1")
          .where(asql.column("column1").isEqualTo(2))
          .limit(1);

        it("has a top clause in the beginning in ansi", () -> {
          context().vendor(Vendor::ansi);

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT TOP 1 column1 FROM table1 WHERE column1 = 2");
        });

        it("has a top clause in the end of the statement in postgreslq", () -> {
          context().vendor(Vendor::postgresql);

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT column1 FROM table1 WHERE column1 = 2 limit 1");
        });

      });

      describe("projection select", () -> {
        AgnosticStatement select = asql.select(asql.column("column1"), asql.column("column2")).from("table1").limit(1);

        it("has a top clause in the beginning in ansi", () -> {
          context().vendor(Vendor::ansi);

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT TOP 1 column1, column2 FROM table1");
        });

        it("has a top clause in the end of the statement in postgreslq", () -> {
          context().vendor(Vendor::postgresql);

          String translated = context().vendor().translate(select);

          assertThat(translated).isEqualTo("SELECT column1, column2 FROM table1 limit 1");
        });
      });

      describe("limit inside subquery", () -> {
        AgnosticStatement select = asql.update("tabla1").setting(
          asql.column("columna1").to(
            asql.select("columna2")
              .from("tabla2")
              .where(asql.column("columna2")
                .isEqualTo(asql.column("columna1")))
              .limit(1)
          ));

        it("in ansi uses top", () -> {
          context().vendor(Vendor::ansi);

          String translated = context().vendor().translate(select);

          assertThat(translated)
            .isEqualTo("UPDATE tabla1 SET columna1 = ( SELECT TOP 1 'columna2' FROM tabla2 WHERE columna2 = columna1 )");
        });

        it("in postgresql uses limit", () -> {
          context().vendor(Vendor::postgresql);

          String translated = context().vendor().translate(select);

          assertThat(translated)
            .isEqualTo("UPDATE tabla1 SET columna1 = ( SELECT 'columna2' FROM tabla2 WHERE columna2 = columna1 limit 1 )");
        });

      });
    });
  }
}
