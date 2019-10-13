package ar.com.kfgodel.asql.conditions;

import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import com.google.common.collect.Lists;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies that sql predicate conditions are expressable in an agnostic sql
 *
 * Created by tenpines on 14/09/15.
 */
@RunWith(JavaSpecRunner.class)
public class ConditionExpressionTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {
        Asql asql = AsqlBuilder.create();

        describe("sql predicate conditions includes", ()->{

            context().vendor(() -> Vendor.ansi());
            context().translated(() -> context().vendor().translate(context().condition()));

            it("IS NULL", () -> {
                context().condition(() -> asql.column("columnName").isNull());

                assertThat(context().translated()).isEqualTo("columnName IS NULL");
            });

            it("IS NOT NULL", () -> {
                context().condition(() -> asql.column("columnName").isNotNull());

                assertThat(context().translated()).isEqualTo("columnName IS NOT NULL");
            });

            it("equal to a value", () -> {
                context().condition(() -> asql.column("columnName").isEqualTo("text"));

                assertThat(context().translated()).isEqualTo("columnName = 'text'");
            });

            it("equal to another column", () -> {
                context().condition(() -> asql.column("columnName").isEqualToColumn("anotherColumn"));

                assertThat(context().translated()).isEqualTo("columnName = anotherColumn");
            });

            it("NOT equal to a value", () -> {
                context().condition(() -> asql.column("columnName").isNotEqualTo("text"));

                assertThat(context().translated()).isEqualTo("columnName <> 'text'");
            });

            it("NOT equal to another column", () -> {
                context().condition(() -> asql.column("columnName").isNotEqualToColumn("anotherColumn"));

                assertThat(context().translated()).isEqualTo("columnName <> anotherColumn");
            });

            it("less than a value", () -> {
                context().condition(() -> asql.column("columnName").isLessThan(1.2));

                assertThat(context().translated()).isEqualTo("columnName < 1.2");
            });

            it("less or equal than a value", ()->{
                context().condition(() -> asql.column("columnName").isLessOrEqualThan(1.2));

                assertThat(context().translated()).isEqualTo("columnName <= 1.2");
            });

            it("less than a column", ()->{
                context().condition(() -> asql.column("columnName").isLessThanColumn("otherColumn"));

                assertThat(context().translated()).isEqualTo("columnName < otherColumn");
            });

            it("less or equal than a column", ()->{
                context().condition(() -> asql.column("columnName").isLessThanOrEqualColumn("otherColumn"));

                assertThat(context().translated()).isEqualTo("columnName <= otherColumn");
            });

            it("greater than a value", ()->{
                context().condition(() -> asql.column("columnName").isGreaterThan(1.2));

                assertThat(context().translated()).isEqualTo("columnName > 1.2");
            });

            it("greater or equal than a value", ()->{
                context().condition(() -> asql.column("columnName").isGreaterOrEqualThan(1.2));

                assertThat(context().translated()).isEqualTo("columnName >= 1.2");
            });

            it("greater than a column", ()->{
                context().condition(() -> asql.column("columnName").isGreaterThanColumn("otherColumn"));

                assertThat(context().translated()).isEqualTo("columnName > otherColumn");
            });

            it("greater or equal than a column", ()->{
                context().condition(() -> asql.column("columnName").isGreaterOrEqualThanColumn("otherColumn"));

                assertThat(context().translated()).isEqualTo("columnName >= otherColumn");
            });

            it("LIKE a value", ()->{
                context().condition(() -> asql.column("columnName").isLike("%middle%"));

                assertThat(context().translated()).isEqualTo("columnName LIKE '%middle%'");
            });

            it("NOT LIKE a value", ()->{
                context().condition(() -> asql.column("columnName").isNotLike("%middle%"));

                assertThat(context().translated()).isEqualTo("columnName NOT LIKE '%middle%'");
            });

            it("starts with a value", ()->{
                context().condition(() -> asql.column("columnName").startsWith("prefix"));

                assertThat(context().translated()).isEqualTo("columnName LIKE 'prefix%'");
            });

            it("does not start with a value", ()->{
                context().condition(() -> asql.column("columnName").doesNotStartWith("prefix"));

                assertThat(context().translated()).isEqualTo("columnName NOT LIKE 'prefix%'");
            });

            it("ends with a value", ()->{
                context().condition(() -> asql.column("columnName").endsWith("suffix"));

                assertThat(context().translated()).isEqualTo("columnName LIKE '%suffix'");
            });

            it("does not end with a value", ()->{
                context().condition(() -> asql.column("columnName").doesNotEndWith("suffix"));

                assertThat(context().translated()).isEqualTo("columnName NOT LIKE '%suffix'");
            });

            it("contains a value", ()->{
                context().condition(() -> asql.column("columnName").contains("middle"));

                assertThat(context().translated()).isEqualTo("columnName LIKE '%middle%'");
            });

            it("does not contain a value", ()->{
                context().condition(() -> asql.column("columnName").doesNotContain("middle"));

                assertThat(context().translated()).isEqualTo("columnName NOT LIKE '%middle%'");
            });

            it("IN a collection of values", ()->{
                context().condition(() -> asql.column("columnName").isIn(Lists.newArrayList(1, "text")));

                assertThat(context().translated()).isEqualTo("columnName IN ( 1, 'text' )");
            });

            it("NOT IN a collection of values", ()->{
                context().condition(() -> asql.column("columnName").isNotIn(Lists.newArrayList(1, "text")));

                assertThat(context().translated()).isEqualTo("columnName NOT IN ( 1, 'text' )");
            });

        });
    }
}
