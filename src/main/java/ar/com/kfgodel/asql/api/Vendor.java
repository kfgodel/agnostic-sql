package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.impl.vendors.VendorImpl;

/**
 * This type represents a database vendor that has its own sql dialect
 * Created by kfgodel on 13/07/15.
 */
public interface Vendor {


    static Vendor ansi() {
        return VendorImpl.create("ansi");
    }

    /**
     * @return The classpath directory where vendor templates are located
     */
    String getTemplateLocationInClasspath();
}
