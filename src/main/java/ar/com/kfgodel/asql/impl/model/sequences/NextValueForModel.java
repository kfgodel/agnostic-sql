package ar.com.kfgodel.asql.impl.model.sequences;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SequenceReferenceModel;

/**
 * This class represents the model for declaring a next value on a sequence
 * Created by dario.garcia on 19/04/17.
 */
public class NextValueForModel implements AgnosticModel {

  private SequenceReferenceModel sequence;

  public SequenceReferenceModel getSequence() {
    return sequence;
  }

  @Override
  public String getTemplatePath() {
    return "/sequences/_nextValueFor.ftl";
  }

  public static NextValueForModel create(SequenceReferenceModel sequence) {
    NextValueForModel model = new NextValueForModel();
    model.sequence = sequence;
    return model;
  }

}
