package ar.com.kfgodel.asql.api.vendors;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
import ar.com.kfgodel.asql.impl.vendors.VendorImpl;

/**
 * This type represents a database vendor that has its own sql dialect
 * Created by kfgodel on 13/07/15.
 */
public interface Vendor {


    static Vendor ansi() {
        return VendorImpl.create("ansi");
    }
    static Vendor sqlserver() {
        return VendorImpl.create("sqlserver");
    }
    static Vendor hsqldb() {
        return VendorImpl.create("hsqldb");
    }

    /**
     * @return The classpath directory where vendor templates are located
     */
    String getTemplateLocationInClasspath();

    /**
     * Translates the given agnostic statement into this vendor specific sql
     * @param statement The abstract statement
     * @return The interpreted sql specific to this vendor
     */
    default String translate(AgnosticConstruct statement){
        return TemplateInterpreter.create(this).translate(statement);
    };
}
