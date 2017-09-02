package ar.com.kfgodel.asql.api.types;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.types.DataTypeImpl;

/**
 * This type represents an agnostic data type that can be translated to a vendor specific type
 * Created by kfgodel on 13/07/15.
 */
public interface DataType extends AgnosticConstruct {

  /**
   * Name of this type, used to compare to other types
   *
   * @return The vendor agnostic type name
   */
  String getAgnosticName();

  static DataType time() {
    return DataTypeImpl.create("time", Internal.asConstructs());
  }

  static DataType doublenic() {
    return DataTypeImpl.create("doublenic", Internal.asConstructs());
  }

  static DataType decimal() {
    return DataTypeImpl.create("decimal", Internal.asConstructs());
  }

  static DataType bigInteger() {
    return DataTypeImpl.create("bigint", Internal.asConstructs());
  }

  static DataType timestamp() {
    return DataTypeImpl.create("timestamp", Internal.asConstructs());
  }

  static DataType integer() {
    return DataTypeImpl.create("integer", Internal.asConstructs());
  }

  static DataType fk() {
    return DataTypeImpl.create("fk", Internal.asConstructs());
  }

  static DataType pk() {
    return DataTypeImpl.create("pk", Internal.asConstructs());
  }

  static DataType shortString() {
    return DataTypeImpl.create("shortstring", Internal.asConstructs());
  }

  static DataType largeText() {
    return DataTypeImpl.create("largetext", Internal.asConstructs());
  }

  static DataType limitedText(int maximumSize) {
    return DataTypeImpl.create("limitedtext", Internal.asConstructs(maximumSize));
  }

  static DataType date() {
    return DataTypeImpl.create("date", Internal.asConstructs());
  }

  static DataType booleanic() {
    return DataTypeImpl.create("booleanic", Internal.asConstructs());
  }

  static DataType blob() {
    return DataTypeImpl.create("blob", Internal.asConstructs());
  }
  static DataType clob() {
    return DataTypeImpl.create("clob", Internal.asConstructs());
  }

}
