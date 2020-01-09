package ar.com.kfgodel.asql.impl.vendors;

import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.interpreter.TemplateInterpreter;
import ar.com.kfgodel.nary.api.Nary;

/**
 * This type implements the vendor behavior by using classpath located templates,
 * and a priority base template lookup to convert agnostic queries to vendor queries
 * Created by kfgodel on 13/07/15.
 */
public class ClasspathTemplatingVendor implements Vendor {

  private String[] priorityOrderedTemplateLocations;

  public Nary<String> getTemplateLocationInClasspath() {
    return Nary.create(priorityOrderedTemplateLocations);
  }

  public static ClasspathTemplatingVendor create(String... priorityOrderedTemplateLocations) {
    ClasspathTemplatingVendor vendor = new ClasspathTemplatingVendor();
    vendor.priorityOrderedTemplateLocations = priorityOrderedTemplateLocations;
    return vendor;
  }

  @Override
  public VendorInterpreter getInterpreter() {
    Nary<String> templateLocationInClasspath = this.getTemplateLocationInClasspath();
    return TemplateInterpreter.create(templateLocationInClasspath);
  }
}
