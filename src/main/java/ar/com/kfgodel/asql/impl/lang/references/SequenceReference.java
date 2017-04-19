package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.references.SequenceReferenceModel;

/**
 * This type represents a reference to a specific sequence
 * Created by dario.garcia on 19/04/17.
 */
public class SequenceReference implements AgnosticConstruct {

  private String sequenceName;

  @Override
  public SequenceReferenceModel parseModel() {
    return SequenceReferenceModel.create(sequenceName);
  }

  public static SequenceReference create(String sequenceName) {
    SequenceReference reference = new SequenceReference();
    reference.sequenceName = sequenceName;
    return reference;
  }

}
