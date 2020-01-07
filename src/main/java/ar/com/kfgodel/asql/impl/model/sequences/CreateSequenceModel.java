package ar.com.kfgodel.asql.impl.model.sequences;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SequenceReferenceModel;
import ar.com.kfgodel.nary.api.Nary;
import ar.com.kfgodel.nary.api.Unary;

/**
 * Esta clase representa el modelo de una sentencia para crear una secuencia
 * Created by dario.garcia on 02/09/17.
 */
public class CreateSequenceModel implements AgnosticModel {

  private SequenceReferenceModel sequence;
  private Unary<Long> startingValue;
  private Unary<Long> incrementValue;

  @Override
  public String getTemplatePath() {
    return "/sequences/createSequence.ftl";
  }

  public SequenceReferenceModel getSequence() {
    return sequence;
  }

  public Long getStartingValue() {
    return startingValue
      .orElseThrow(() -> new IllegalStateException("sequence start value is not defined"));
  }

  public Long getIncrementValue() {
    return incrementValue
      .orElseThrow(() -> new IllegalStateException("sequence increment value is not defined"));
  }

  public boolean getUsesStartValue() {
    return startingValue.isPresent();
  }

  public boolean getUsesIncrementValue() {
    return incrementValue.isPresent();
  }

  public static CreateSequenceModel create(SequenceReferenceModel sequenceReference) {
    CreateSequenceModel model = new CreateSequenceModel();
    model.sequence = sequenceReference;
    model.incrementValue = Nary.empty();
    model.startingValue = Nary.empty();
    return model;
  }

  public CreateSequenceModel withStartingValue(Long value) {
    this.startingValue = Nary.of(value);
    return this;
  }

  public CreateSequenceModel withIncrementValue(Long value) {
    this.incrementValue = Nary.of(value);
    return this;
  }


}
