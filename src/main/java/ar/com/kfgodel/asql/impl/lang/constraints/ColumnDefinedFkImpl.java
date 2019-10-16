package ar.com.kfgodel.asql.impl.lang.constraints;

import ar.com.kfgodel.asql.api.constraints.ColumnDefinedFk;
import ar.com.kfgodel.asql.api.constraints.FkConstraintDeclaration;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.ColumnReference;
import ar.com.kfgodel.asql.impl.lang.references.ConstraintReference;

import java.util.List;

/**
 * Created by kfgodel on 16/07/15.
 */
public class ColumnDefinedFkImpl implements ColumnDefinedFk {

  private NamedConstraintImpl previousNode;
  private List<ColumnReference> sourceColumns;


  public ConstraintReference getConstraint() {
    return previousNode.getConstraintReference();
  }

  public List<ColumnReference> getSourceColumns() {
    return sourceColumns;
  }

  @Override
  public FkConstraintDeclaration to(String referencedTableName) {
    return FkConstraintDeclarationImpl.create(this, Internal.table(referencedTableName));
  }

  public static ColumnDefinedFkImpl create(NamedConstraintImpl previousNode, List<ColumnReference> sourceColumns) {
    ColumnDefinedFkImpl definedFk = new ColumnDefinedFkImpl();
    definedFk.sourceColumns = sourceColumns;
    definedFk.previousNode = previousNode;
    return definedFk;
  }

}
