package ar.com.kfgodel.asql.statements;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.AsqlTestContext;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.create.CreateStatement;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.AsqlBuilder;
import ar.com.kfgodel.asql.impl.model.columns.ColumnDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.ConstraintDeclarationModel;
import ar.com.kfgodel.asql.impl.model.constraints.PkDefinitionModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of the create statement dsl
 * Created by kfgodel on 13/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class CreateStatementTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {
        describe("an agnostic create statement", () -> {

            context().asql(AsqlBuilder::create);

            it("can generate the simplest create model", () -> {

                CreateStatement create = context().asql().createTable("tableName");

                CreateModel createModel = create.parseModel();

                assertThat(createModel.getTable().getTableName()).isEqualTo("tableName");
            });

            it("can declare an id column used as pk",()->{
                CreateStatement create = context().asql().createTable("tableName")
                        .withIdPk();

                CreateModel createModel = create.parseModel();
                ColumnDeclarationModel columnModel = createModel.getColumnDeclarations().get(0);

                assertThat(columnModel.getColumn().getColumnName()).isEqualTo("id");
                assertThat(columnModel.getColumnType()).isEqualTo(DataType.pk().parseModel());

                ConstraintDeclarationModel contraint = createModel.getTableConstraints().get(0);
                assertThat(contraint.getDefinition()).isInstanceOf(PkDefinitionModel.class);
                PkDefinitionModel definition = (PkDefinitionModel) contraint.getDefinition();
                assertThat(definition.getColumns().get(0).getColumnName()).isEqualTo("id");
            });

            describe("for extra columns", () -> {

                it("can declare the column type",()->{
                    Asql asql = context().asql();
                    CreateStatement create = asql
                            .createTable("tableName")
                            .with(asql.column("columnName").typed(DataType.bigInteger()));

                    CreateModel createModel = create.parseModel();
                    ColumnDeclarationModel columnModel = createModel.getColumnDeclarations().get(0);

                    assertThat(columnModel.getColumn().getColumnName()).isEqualTo("columnName");
                    assertThat(columnModel.getColumnType()).isEqualTo(DataType.bigInteger().parseModel());
                });

                it("can declare a column nullity",()->{
                    Asql asql = context().asql();
                    CreateStatement create = asql
                            .createTable("tableName")
                            .with(asql.column("column1").typed(DataType.bigInteger()).nonNullable(),
                                    asql.column("column2").typed(DataType.shortString()).nullable());

                    CreateModel createModel = create.parseModel();

                    ColumnDeclarationModel column1Model = createModel.getColumnDeclarations().get(0);
                    assertThat(column1Model.getNullity()).isEqualTo("NOT NULL");

                    ColumnDeclarationModel column2Model = createModel.getColumnDeclarations().get(1);
                    assertThat(column2Model.getNullity()).isEqualTo("NULL");
                });

                it("can declare a column default value",()->{
                    Asql asql = context().asql();
                    CreateStatement create = asql
                            .createTable("tableName")
                            .with(asql.column("columnName").typed(DataType.bigInteger()).defaultedTo(4));

                    CreateModel createModel = create.parseModel();
                    ColumnDeclarationModel columnModel = createModel.getColumnDeclarations().get(0);

                    ExplicitValueModel definedValue = (ExplicitValueModel) columnModel.getDefaultValue();
                    assertThat(definedValue.getValue()).isEqualTo(4);
                });

            });


        });

    }
}