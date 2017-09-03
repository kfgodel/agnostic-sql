package ar.com.kfgodel.asql.impl.lang.sequence;

import ar.com.kfgodel.asql.api.sequences.CreateSequenceStatement;
import ar.com.kfgodel.asql.impl.lang.references.SequenceReference;
import ar.com.kfgodel.asql.impl.model.references.SequenceReferenceModel;
import ar.com.kfgodel.asql.impl.model.sequences.CreateSequenceModel;

/**
 * Created by dario.garcia on 02/09/17.
 */
public class NameDefinedCreateSequenceDeclaration implements CreateSequenceDeclaration {

  private SequenceReference sequenceReference;

  @Override
  public CreateSequenceStatement startWith(long initialValue) {
    return StartValueDefinedCreateSequenceDeclaration.create(this, initialValue);
  }

  @Override
  public CreateSequenceStatement incrementBy(long incrementStep) {
    return IncrementValueDefinedCreateSequenceDeclaration.create(this, incrementStep);
  }

  @Override
  public CreateSequenceModel parseModel() {
    SequenceReferenceModel sequenceReference = this.sequenceReference.parseModel();
    return CreateSequenceModel.create(sequenceReference);
  }

  public static NameDefinedCreateSequenceDeclaration create(SequenceReference sequenceReference) {
    NameDefinedCreateSequenceDeclaration declaration = new NameDefinedCreateSequenceDeclaration();
    declaration.sequenceReference = sequenceReference;
    return declaration;
  }

}
