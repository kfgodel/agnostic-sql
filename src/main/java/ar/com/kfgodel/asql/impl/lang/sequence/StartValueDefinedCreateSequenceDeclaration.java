package ar.com.kfgodel.asql.impl.lang.sequence;

import ar.com.kfgodel.asql.api.sequences.CreateSequenceStatement;
import ar.com.kfgodel.asql.impl.model.sequences.CreateSequenceModel;

/**
 * Created by dario.garcia on 02/09/17.
 */
public class StartValueDefinedCreateSequenceDeclaration implements CreateSequenceDeclaration {

  private CreateSequenceDeclaration previousNode;
  private Long startingValue;

  @Override
  public CreateSequenceStatement startWith(long initialValue) {
    return StartValueDefinedCreateSequenceDeclaration.create(previousNode, initialValue);
  }

  @Override
  public CreateSequenceStatement incrementBy(long incrementStep) {
    return IncrementValueDefinedCreateSequenceDeclaration.create(this, incrementStep);
  }

  @Override
  public CreateSequenceModel parseModel() {
    return previousNode.parseModel()
      .withStartingValue(startingValue);
  }

  public static StartValueDefinedCreateSequenceDeclaration create(CreateSequenceDeclaration previousNode, Long startingValue) {
    StartValueDefinedCreateSequenceDeclaration declaration = new StartValueDefinedCreateSequenceDeclaration();
    declaration.previousNode = previousNode;
    declaration.startingValue = startingValue;
    return declaration;
  }

}
