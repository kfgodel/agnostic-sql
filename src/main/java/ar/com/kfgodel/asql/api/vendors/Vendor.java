package ar.com.kfgodel.asql.api.vendors;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.impl.vendors.ClasspathTemplatingVendor;

/**
 * This type represents a database vendor that has its own sql dialect
 * Created by kfgodel on 13/07/15.
 */
public interface Vendor {


  static Vendor ansi() {
    return ClasspathTemplatingVendor.create("ansi");
  }

  static Vendor sqlserver() {
    return ClasspathTemplatingVendor.create("sqlserver", "ansi");
  }

  static Vendor hsqldb() {
    return ClasspathTemplatingVendor.create("hsqldb", "ansi");
  }

  /**
   * Translates the given agnostic statement into this vendor specific sql
   *
   * @param statement The abstract statement
   * @return The interpreted sql specific to this vendor
   */
  default String translate(AgnosticConstruct statement) {
    return getInterpreter().translate(statement);
  }

  /**
   * @return The vendor specific interpreter for asql translation
   */
  VendorInterpreter getInterpreter();
}
