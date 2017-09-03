package ar.com.kfgodel.asql.impl.lang.sequence;

import ar.com.kfgodel.asql.api.sequences.CreateSequenceStatement;
import ar.com.kfgodel.asql.impl.model.sequences.CreateSequenceModel;

/**
 * Created by dario.garcia on 02/09/17.
 */
public class IncrementValueDefinedCreateSequenceDeclaration implements CreateSequenceDeclaration {

  private CreateSequenceDeclaration previousNode;
  private Long incrementValue;

  @Override
  public CreateSequenceModel parseModel() {
    return previousNode.parseModel()
      .withIncrementValue(incrementValue);
  }

  @Override
  public CreateSequenceStatement startWith(long initialValue) {
    return StartValueDefinedCreateSequenceDeclaration.create(this, initialValue);
  }

  @Override
  public CreateSequenceStatement incrementBy(long incrementStep) {
    return IncrementValueDefinedCreateSequenceDeclaration.create(previousNode, incrementStep);
  }

  public static IncrementValueDefinedCreateSequenceDeclaration create(CreateSequenceDeclaration previousNode, Long incrementValue) {
    IncrementValueDefinedCreateSequenceDeclaration declaration = new IncrementValueDefinedCreateSequenceDeclaration();
    declaration.previousNode = previousNode;
    declaration.incrementValue = incrementValue;
    return declaration;
  }

}
