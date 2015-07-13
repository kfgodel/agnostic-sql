package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.AsqlBuilderImpl;
import ar.com.kfgodel.asql.impl.tree.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.tree.UpdateModel;
import ar.com.kfgodel.asql.impl.value.ExplicitValueModel;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 13/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class UpdateStatementTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {
        describe("an agnostic update statement", () -> {

             it("can express a simple update", () -> {
                 AsqlBuilder asql = AsqlBuilderImpl.create();

                 UnrestrictedUpdate updateStatement = asql.update("tableName").set(asql.column("columnName").to("value1"));
                 UpdateModel updateModel = updateStatement.parseModel();

                 assertThat(updateModel.getTableName()).isEqualTo("tableName");

                 ColumnAssignmentModel assignment = updateModel.getColumnAssignments().get(0);
                 assertThat(assignment.getColumnName()).isEqualTo("columnName");

                 ExplicitValueModel assignedValue = (ExplicitValueModel) assignment.getAssignedValue();
                 assertThat(assignedValue.getValue()).isEqualTo("value1");
             });
        });

    }
}