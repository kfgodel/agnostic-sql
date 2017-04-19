package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents a model for referencing sequences
 * Created by dario.garcia on 19/04/17.
 */
public class SequenceReferenceModel implements AgnosticModel {

  private String sequenceName;

  public String getSequenceName() {
    return sequenceName;
  }

  @Override
  public String getTemplatePath() {
    return "/references/_sequence.ftl";
  }

  public static SequenceReferenceModel create(String sequenceName) {
    SequenceReferenceModel model = new SequenceReferenceModel();
    model.sequenceName = sequenceName;
    return model;
  }

}
