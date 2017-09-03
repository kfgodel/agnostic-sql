package ar.com.kfgodel.asql.impl.model.sequences;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.references.SequenceReferenceModel;
import ar.com.kfgodel.nary.api.optionals.Optional;

/**
 * Esta clase representa el modelo de una sentencia para crear una secuencia
 * Created by dario.garcia on 02/09/17.
 */
public class CreateSequenceModel implements AgnosticModel {

  private SequenceReferenceModel sequence;
  private Optional<Long> startingValue;
  private Optional<Long> incrementValue;

  @Override
  public String getTemplatePath() {
    return "/sequences/createSequence.ftl";
  }

  public SequenceReferenceModel getSequence() {
    return sequence;
  }

  public Long getStartingValue() {
    return startingValue
      .orElseThrow(()-> new IllegalStateException("sequence start value is not defined"));
  }

  public Long getIncrementValue() {
    return incrementValue
      .orElseThrow(()-> new IllegalStateException("sequence increment value is not defined"));
  }

  public boolean getUsesStartValue(){
    return startingValue.isPresent();
  }

  public boolean getUsesIncrementValue(){
    return incrementValue.isPresent();
  }

  public static CreateSequenceModel create(SequenceReferenceModel sequenceReference) {
    CreateSequenceModel model = new CreateSequenceModel();
    model.sequence = sequenceReference;
    model.incrementValue = Optional.empty();
    model.startingValue = Optional.empty();
    return model;
  }

  public CreateSequenceModel withStartingValue(Long value){
    this.startingValue = Optional.of(value);
    return this;
  }

  public CreateSequenceModel withIncrementValue(Long value){
    this.incrementValue = Optional.of(value);
    return this;
  }


}
