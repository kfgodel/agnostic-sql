package ar.com.kfgodel.asql.impl.lang.operators;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.references.OperatorReference;
import ar.com.kfgodel.asql.impl.model.operators.NotOperatorModel;

/**
 * This type serves as an access point to the agnostic operators
 * Created by tenpines on 19/09/15.
 */
public interface Operator {

  static AgnosticConstruct is() {
    return OperatorReference.create("is");
  }

  static AgnosticConstruct equal() {
    return OperatorReference.create("equal");
  }

  static AgnosticConstruct different() {
    return OperatorReference.create("different");
  }

  static AgnosticConstruct less() {
    return OperatorReference.create("less");
  }

  static AgnosticConstruct greater() {
    return OperatorReference.create("greater");
  }

  static AgnosticConstruct lessOrEqual() {
    return OperatorReference.create("lessOrEqual");
  }

  static AgnosticConstruct greaterOrEqual() {
    return OperatorReference.create("greaterOrEqual");
  }

  static AgnosticConstruct like() {
    return OperatorReference.create("like");
  }

  static <T extends AgnosticConstruct> T notPlacedBefore(T negatedConstruct) {
    NotOperator<T> negated = NotOperator.create(negatedConstruct, NotOperatorModel::createPlacedBefore);
    return (T) negated;
  }

  static <T extends AgnosticConstruct> T notPlacedAfter(T negatedConstruct) {
    NotOperator<T> negated = NotOperator.create(negatedConstruct, NotOperatorModel::createPlacedAfter);
    return (T) negated;
  }

  static AgnosticConstruct in() {
    return OperatorReference.create("in");
  }

  static AgnosticConstruct and() {
    return OperatorReference.create("and");
  }

  static AgnosticConstruct or() {
    return OperatorReference.create("or");
  }

  static AgnosticConstruct isNot() {
    return notPlacedAfter(is());
  }

  static AgnosticConstruct notLike() {
    return notPlacedBefore(like());
  }

  static AgnosticConstruct notIn() {
    return notPlacedBefore(in());
  }
}
