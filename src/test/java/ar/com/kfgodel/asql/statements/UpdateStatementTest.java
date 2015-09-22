package ar.com.kfgodel.asql.statements;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;
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
                 Asql asql = AsqlBuilder.create();

                 UnrestrictedUpdate updateStatement = asql.update("tableName").setting(asql.column("columnName").to("value1"));
                 UpdateModel updateModel = updateStatement.parseModel();

                 assertThat(updateModel.getTable().getTableName()).isEqualTo("tableName");

                 ColumnAssignmentModel assignment = updateModel.getColumnAssignments().get(0);
                 assertThat(assignment.getColumn().getColumnName()).isEqualTo("columnName");

                 ExplicitValueModel assignedValue = (ExplicitValueModel) assignment.getAssignedValue();
                 assertThat(assignedValue.getValue()).isEqualTo("value1");
             });
        });

    }
}