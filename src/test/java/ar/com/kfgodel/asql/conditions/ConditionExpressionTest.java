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

        describe("sql predicate conditions", ()->{

            context().interpreter(() -> TemplateInterpreter.create(Vendor.ansi()));
            context().translated(() -> context().interpreter().translate(context().condition().parseModel()));

            it("includes IS NULL", () -> {
                context().condition(() -> asql.column("columnName").isNull());

                assertThat(context().translated()).isEqualTo("columnName IS NULL");
            });

            it("includes IS NOT NULL", () -> {
                context().condition(() -> asql.column("columnName").isNotNull());

                assertThat(context().translated()).isEqualTo("columnName IS NOT NULL");
            });

        });
    }
}
