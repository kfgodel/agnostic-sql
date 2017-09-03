package ar.com.kfgodel.asql.api.sequences;

import ar.com.kfgodel.asql.api.AgnosticStatement;

/**
 * Created by dario.garcia on 02/09/17.
 */
public interface CreateSequenceStatement extends AgnosticStatement {

  CreateSequenceStatement startWith(long initialValue);

  CreateSequenceStatement incrementBy(long incrementStep);
}
