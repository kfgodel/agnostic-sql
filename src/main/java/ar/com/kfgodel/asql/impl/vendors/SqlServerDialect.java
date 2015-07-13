package ar.com.kfgodel.asql.impl.vendors;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.VendorDialect;

import java.util.List;

/**
 * This type represents the translator for agnostic statements to sqlserver specific ones
 * Created by kfgodel on 12/07/15.
 */
public class SqlServerDialect implements VendorDialect {

    private VendorSpecificDialect ownDialect;

    @Override
    public String translate(AgnosticStatement statement) {
        return ownDialect.translate(statement);
    }

    @Override
    public String translate(List<AgnosticStatement> statements) {
        return ownDialect.translate(statements);
    }

    public static SqlServerDialect create() {
        SqlServerDialect dialect = new SqlServerDialect();
        dialect.ownDialect = VendorSpecificDialect.create("sqlserver");
        return dialect;
    }

}
