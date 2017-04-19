package ar.com.kfgodel.asql.impl.lang.sequence;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.lang.references.SequenceReference;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SequenceReferenceModel;
import ar.com.kfgodel.asql.impl.model.sequences.NextValueForModel;

/**
 * This class represents the declaration of a next value for a sequence
 * Created by dario.garcia on 19/04/17.
 */
public class NextValueForConstruct implements AgnosticConstruct {

  private SequenceReference sequenceReference;

  @Override
  public AgnosticModel parseModel() {
    SequenceReferenceModel referenceModel = sequenceReference.parseModel();
    return NextValueForModel.create(referenceModel);
  }

  public static NextValueForConstruct create(SequenceReference sequenceReference) {
    NextValueForConstruct construct = new NextValueForConstruct();
    construct.sequenceReference = sequenceReference;
    return construct;
  }

}
