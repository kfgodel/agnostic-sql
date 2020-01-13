package ar.com.kfgodel.asql;

import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import info.kfgodel.jspek.api.JavaSpec;
import info.kfgodel.jspek.api.JavaSpecRunner;
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

        assertThat(ansi.translate(DataType.bigInteger())).isEqualTo("BIGINT");
        assertThat(ansi.translate(DataType.integer())).isEqualTo("INTEGER");

        assertThat(ansi.translate(DataType.decimal())).isEqualTo("DECIMAL");
        assertThat(ansi.translate(DataType.doublenic())).isEqualTo("DOUBLE");

        assertThat(ansi.translate(DataType.shortString())).isEqualTo("VARCHAR(255)");
        assertThat(ansi.translate(DataType.largeText())).isEqualTo("CLOB");
        assertThat(ansi.translate(DataType.limitedText(1024))).isEqualTo("VARCHAR(1024)");

        assertThat(ansi.translate(DataType.timestamp())).isEqualTo("TIMESTAMP");
        assertThat(ansi.translate(DataType.time())).isEqualTo("TIME");
        assertThat(ansi.translate(DataType.date())).isEqualTo("DATE");

        assertThat(ansi.translate(DataType.pk())).isEqualTo("BIGINT PRIMARY KEY NOT NULL");
        assertThat(ansi.translate(DataType.fk())).isEqualTo("BIGINT");

        assertThat(ansi.translate(DataType.booleanic())).isEqualTo("BOOLEAN");

        assertThat(ansi.translate(DataType.blob())).isEqualTo("BLOB");
        assertThat(ansi.translate(DataType.clob())).isEqualTo("CLOB");
      });
      it("have sqlserver translations", () -> {
        Vendor sqlserver = Vendor.sqlserver();

        assertThat(sqlserver.translate(DataType.bigInteger())).isEqualTo("BIGINT");
        assertThat(sqlserver.translate(DataType.integer())).isEqualTo("INT");

        assertThat(sqlserver.translate(DataType.decimal())).isEqualTo("DECIMAL");
        assertThat(sqlserver.translate(DataType.doublenic())).isEqualTo("FLOAT");

        assertThat(sqlserver.translate(DataType.shortString())).isEqualTo("VARCHAR(255)");
        assertThat(sqlserver.translate(DataType.largeText())).isEqualTo("TEXT");
        assertThat(sqlserver.translate(DataType.limitedText(1024))).isEqualTo("VARCHAR(1024)");

        assertThat(sqlserver.translate(DataType.timestamp())).isEqualTo("DATETIME2");
        assertThat(sqlserver.translate(DataType.time())).isEqualTo("TIME");
        assertThat(sqlserver.translate(DataType.date())).isEqualTo("DATE");

        assertThat(sqlserver.translate(DataType.pk())).isEqualTo("BIGINT PRIMARY KEY NOT NULL");
        assertThat(sqlserver.translate(DataType.fk())).isEqualTo("BIGINT");

        assertThat(sqlserver.translate(DataType.booleanic())).isEqualTo("BIT");

        assertThat(sqlserver.translate(DataType.blob())).isEqualTo("VARBINARY(MAX)");
        assertThat(sqlserver.translate(DataType.clob())).isEqualTo("CLOB");
      });
      it("have hsqldb translations", () -> {
        Vendor hsqldb = Vendor.hsqldb();

        assertThat(hsqldb.translate(DataType.bigInteger())).isEqualTo("BIGINT");
        assertThat(hsqldb.translate(DataType.integer())).isEqualTo("INTEGER");

        assertThat(hsqldb.translate(DataType.decimal())).isEqualTo("DECIMAL");
        assertThat(hsqldb.translate(DataType.doublenic())).isEqualTo("DOUBLE");

        assertThat(hsqldb.translate(DataType.shortString())).isEqualTo("VARCHAR(255)");
        assertThat(hsqldb.translate(DataType.largeText())).isEqualTo("CLOB");
        assertThat(hsqldb.translate(DataType.limitedText(1024))).isEqualTo("VARCHAR(1024)");

        assertThat(hsqldb.translate(DataType.timestamp())).isEqualTo("TIMESTAMP");
        assertThat(hsqldb.translate(DataType.time())).isEqualTo("TIME");
        assertThat(hsqldb.translate(DataType.date())).isEqualTo("DATE");

        assertThat(hsqldb.translate(DataType.pk())).isEqualTo("BIGINT PRIMARY KEY NOT NULL");
        assertThat(hsqldb.translate(DataType.fk())).isEqualTo("BIGINT");

        assertThat(hsqldb.translate(DataType.booleanic())).isEqualTo("BOOLEAN");
        assertThat(hsqldb.translate(DataType.blob())).isEqualTo("BLOB");
        assertThat(hsqldb.translate(DataType.clob())).isEqualTo("CLOB");
      });

      it("have postgresql translations", () -> {
        Vendor postgresql = Vendor.postgresql();

        assertThat(postgresql.translate(DataType.bigInteger())).isEqualTo("BIGINT");
        assertThat(postgresql.translate(DataType.integer())).isEqualTo("INTEGER");

        assertThat(postgresql.translate(DataType.decimal())).isEqualTo("NUMERIC");
        assertThat(postgresql.translate(DataType.doublenic())).isEqualTo("DOUBLE PRECISION");

        assertThat(postgresql.translate(DataType.shortString())).isEqualTo("VARCHAR(255)");
        assertThat(postgresql.translate(DataType.largeText())).isEqualTo("TEXT");
        assertThat(postgresql.translate(DataType.limitedText(1024))).isEqualTo("VARCHAR(1024)");

        assertThat(postgresql.translate(DataType.timestamp())).isEqualTo("TIMESTAMP");
        assertThat(postgresql.translate(DataType.time())).isEqualTo("TIME");
        assertThat(postgresql.translate(DataType.date())).isEqualTo("DATE");

        assertThat(postgresql.translate(DataType.pk())).isEqualTo("BIGINT PRIMARY KEY");
        assertThat(postgresql.translate(DataType.fk())).isEqualTo("BIGINT");

        assertThat(postgresql.translate(DataType.booleanic())).isEqualTo("BOOLEAN");
        assertThat(postgresql.translate(DataType.blob())).isEqualTo("bytea");
        assertThat(postgresql.translate(DataType.clob())).isEqualTo("TEXT");
      });
    });


  }
}
