package ar.com.kfgodel.asql.impl.vendors;

import ar.com.kfgodel.asql.api.vendors.Vendor;

/**
 * This type implements the vendor behavior
 * Created by kfgodel on 13/07/15.
 */
public class VendorImpl implements Vendor {


    private String templateLocation;

    @Override
    public String getTemplateLocationInClasspath() {
        return templateLocation;
    }

    public static VendorImpl create(String location) {
        VendorImpl vendor = new VendorImpl();
        vendor.templateLocation = location;
        return vendor;
    }

}
