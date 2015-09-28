package ar.com.kfgodel.asql;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kfgodel on 14/07/15.
 */
@RunWith(JavaSpecRunner.class)
public class DataTypeTest extends JavaSpec<AsqlTestContext> {
    @Override
    public void define() {

        describe("agnostic data types", () -> {
            it("have ansi translations", () -> {
                Vendor ansi = Vendor.ansi();

                assertThat(ansi.translate(DataType.bigInteger())).isEqualTo("bigint");
                assertThat(ansi.translate(DataType.integer())).isEqualTo("integer");

                assertThat(ansi.translate(DataType.shortString())).isEqualTo("VARCHAR(255)");
                assertThat(ansi.translate(DataType.largeText())).isEqualTo("clob");

                assertThat(ansi.translate(DataType.timestamp())).isEqualTo("timestamp");
                assertThat(ansi.translate(DataType.date())).isEqualTo("date");

                assertThat(ansi.translate(DataType.pk())).isEqualTo("bigint generated by default as identity (start with 1)");
                assertThat(ansi.translate(DataType.fk())).isEqualTo("bigint");

                assertThat(ansi.translate(DataType.booleanic())).isEqualTo("boolean");

                assertThat(ansi.translate(DataType.blob())).isEqualTo("BLOB");
            });
            it("have sqlserver translations", () -> {
                Vendor sqlserver = Vendor.sqlserver();

                assertThat(sqlserver.translate(DataType.bigInteger())).isEqualTo("numeric(19,0)");
                assertThat(sqlserver.translate(DataType.integer())).isEqualTo("numeric(19,0)");

                assertThat(sqlserver.translate(DataType.shortString())).isEqualTo("VARCHAR(255)");
                assertThat(sqlserver.translate(DataType.largeText())).isEqualTo("text");

                assertThat(sqlserver.translate(DataType.timestamp())).isEqualTo("datetime");
                assertThat(sqlserver.translate(DataType.date())).isEqualTo("date");

                assertThat(sqlserver.translate(DataType.pk())).isEqualTo("numeric(19,0) identity");
                assertThat(sqlserver.translate(DataType.fk())).isEqualTo("numeric(19,0)");

                assertThat(sqlserver.translate(DataType.booleanic())).isEqualTo("bit");

                assertThat(sqlserver.translate(DataType.blob())).isEqualTo("VARBINARY(MAX)");
            });
            it("have hsqldb translations", () -> {
                Vendor hsqldb = Vendor.hsqldb();

                assertThat(hsqldb.translate(DataType.bigInteger())).isEqualTo("bigint");
                assertThat(hsqldb.translate(DataType.integer())).isEqualTo("integer");

                assertThat(hsqldb.translate(DataType.shortString())).isEqualTo("VARCHAR(255)");
                assertThat(hsqldb.translate(DataType.largeText())).isEqualTo("clob");

                assertThat(hsqldb.translate(DataType.timestamp())).isEqualTo("timestamp");
                assertThat(hsqldb.translate(DataType.date())).isEqualTo("date");

                assertThat(hsqldb.translate(DataType.pk())).isEqualTo("bigint generated by default as identity (start with 1)");
                assertThat(hsqldb.translate(DataType.fk())).isEqualTo("bigint");

                assertThat(hsqldb.translate(DataType.booleanic())).isEqualTo("bit");
                assertThat(hsqldb.translate(DataType.blob())).isEqualTo("BLOB");
            });
        });


    }
}