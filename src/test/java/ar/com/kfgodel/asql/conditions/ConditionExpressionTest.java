package ar.com.kfgodel.asql.conditions;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
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

            context().interpreter(() -> TemplateInterpreter.create(Vendor.ansi()));
            context().translated(() -> context().interpreter().translate(context().condition().parseModel()));

            it("IS NULL", () -> {
                context().condition(() -> asql.column("columnName").isNull());

                assertThat(context().translated()).isEqualTo("columnName IS NULL");
            });

            it("IS NOT NULL", () -> {
                context().condition(() -> asql.column("columnName").isNotNull());

                assertThat(context().translated()).isEqualTo("columnName IS NOT NULL");
            });

            it("equal to a value", () -> {
                context().condition(() -> asql.column("columnName").isEqualsTo("text"));

                assertThat(context().translated()).isEqualTo("columnName = 'text'");
            });

            it("equal to another column", ()->{
                context().condition(() -> asql.column("columnName").isEqualsToColumn("anotherColumn"));

                assertThat(context().translated()).isEqualTo("columnName = anotherColumn");
            });

            it("less than a value", ()->{
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

        });
    }
}
