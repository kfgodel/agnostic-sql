package ar.com.kfgodel.asql.model;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
import ar.com.kfgodel.asql.impl.lang.operators.Operator;
import ar.com.kfgodel.asql.impl.model.columns.ColumnAssignmentModel;
import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;
import com.google.common.collect.Lists;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

/**
 * Created by kfgodel on 12/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class UpdateModelTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {
        describe("an agnostic update statement model", () -> {


            context().updateModel(() -> {
                UpdateModel updateModel = UpdateModel.create("tableName", Lists.newArrayList(ColumnAssignmentModel.create("column1", ExplicitValueModel.create("value1"))));
                updateModel.getWhereClause().setPredicate(PredicateModel.create(ColumnReferenceModel.create("column2"), Operator.equal().parseModel(), ExplicitValueModel.create(3)));
                return updateModel;
            });

            it("throws an error if no assignment defined", ()->{
                try{
                    UpdateModel.create("aTableName", Lists.newArrayList());
                    failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
                }catch (IllegalArgumentException e){
                    assertThat(e).hasMessage("At least one assignment needed");
                }
            });

            it("represents the abstract state of an agnostic sql update statement", () -> {

                UpdateModel updateTree = context().updateModel();

                assertThat(updateTree.getTableName()).isEqualTo("tableName");

                assertThat(updateTree.getColumnAssignments().get(0).getColumnName()).isEqualTo("column1");
                ExplicitValueModel assignedValue = (ExplicitValueModel) updateTree.getColumnAssignments().get(0).getAssignedValue();
                assertThat(assignedValue.getValue()).isEqualTo("value1");

                ColumnReferenceModel leftSide = (ColumnReferenceModel) updateTree.getWhereClause().getPredicate().getLeftSideOperand();
                assertThat(leftSide.getValue()).isEqualTo("column2");
                assertThat(updateTree.getWhereClause().getPredicate().getOperator()).isEqualTo(Operator.equal().parseModel());
                ExplicitValueModel rightSide = (ExplicitValueModel) updateTree.getWhereClause().getPredicate().getRightSideOperand();
                assertThat(rightSide.getValue()).isEqualTo(3);
            });

            it("can be translated to a vendor specific statement", () -> {

                VendorInterpreter interpreter = TemplateInterpreter.create(Vendor.ansi());

                String translatedSql = interpreter.translate(context().updateModel());

                assertThat(translatedSql).isEqualTo("UPDATE tableName SET column1 = 'value1' WHERE column2 = 3");

            });
        });

    }
}