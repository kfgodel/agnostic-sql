package ar.com.kfgodel.asql.api.sequences;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.sequence.NextValueForConstruct;

/**
 * This type defines operation to be done on sequences
 * Created by dario.garcia on 19/04/17.
 */
public interface Sequence {

  /**
   * Creates a construct that asks for next value on a given sequence, to be used
   * as part of a statement
   *
   * @param sequenceName The name of the sequence to increment
   * @return The construct to use on a statement
   */
  static AgnosticConstruct nextValueFor(String sequenceName) {
    return NextValueForConstruct.create(Internal.sequence(sequenceName));
  }

  /**
   * Creates a construct specific to hibernate mapped db using a sequence for ids.
   *
   * @return The construct that asks for next id on the sequence
   */
  static AgnosticConstruct nextHibernateId() {
    return nextValueFor("hibernate_sequence");
  }
}
