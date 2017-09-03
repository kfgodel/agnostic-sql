package ar.com.kfgodel.asql.impl.lang.sequence;

import ar.com.kfgodel.asql.api.sequences.CreateSequenceStatement;
import ar.com.kfgodel.asql.impl.model.sequences.CreateSequenceModel;

/**
 * Created by dario.garcia on 02/09/17.
 */
public interface CreateSequenceDeclaration extends CreateSequenceStatement {

  @Override
  CreateSequenceModel parseModel();
}
