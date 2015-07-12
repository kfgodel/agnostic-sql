package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.asql.api.AStatement;
import ar.com.kfgodel.asql.api.Asql;
import ar.com.kfgodel.asql.api.AsqlBuilder;
import ar.com.kfgodel.asql.impl.AsqlBuilderImpl;
import com.google.common.collect.Lists;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.runner.RunWith;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 11/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class AsqlShowcaseTest extends JavaSpec<TestContext> {
    @Override
    public void define() {


        it("asdasd",()->{

            try {
            /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
                Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);


                ClassTemplateLoader sqlServerTemplates = new ClassTemplateLoader(getClass(), "/sqlserver/");
                ClassTemplateLoader ansiTemplates = new ClassTemplateLoader(getClass(), "/ansi/");
                MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[] { sqlServerTemplates, ansiTemplates });
                cfg.setTemplateLoader(mtl);
                cfg.setDefaultEncoding("UTF-8");
                cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
                Map root = new HashMap();
                root.put("tableName", "Nombre de tabla");
                Map assignment1 = new HashMap();
                assignment1.put("columnName", "colA");
                Map assignment2 = new HashMap();
                assignment2.put("columnName", "colB");
                root.put("columnAssignments", Lists.newArrayList(assignment1, assignment2));
                root.put("conditioned", true);

                Map predicate1 = new HashMap();
                predicate1.put("columnName", "colC");
                predicate1.put("operator", "<=");
                predicate1.put("restrictedValue", "2");
                root.put("predicates", Lists.newArrayList(predicate1));

        /* Get the template (uses cache internally) */
                Template temp = cfg.getTemplate("update.ftl");

        /* Merge data-model with template */
                StringWriter writer = new StringWriter();
                temp.process(root, writer);
                assertThat(writer.toString()).isEqualTo("UPDATE Nombre de tabla SET colA = 1, colB = 1 WHERE colC <= 2");
                // Note: Depending on what `out` is, you may need to call `out.close()`.
                // This is usually the case for file output, but not for servlet output.
            }catch (Exception e){
                throw new RuntimeException("boom",e);
            }
        });

        describe("agnostic sql", () -> {

            describe("for updating rows", () -> {

                it("can be used for sqlserver", () -> {

                    AsqlBuilder asql = AsqlBuilderImpl.create();

                    AStatement statement = asql.update("POSA_EMPLEADOS").set("CATEGORIA_ID").to(1).where(asql.column("CATEGORIA_ID").isNull());

                    String generatedSql = Asql.sqlserver().translate(statement);

                    assertThat(generatedSql).isEqualTo("UPDATE POSA_EMPLEADOS SET CATEGORIA_ID=1 WHERE CATEGORIA_ID IS NULL");

                });

            });

        });



    }
}