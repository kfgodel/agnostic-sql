package ar.com.kfgodel.asql.impl.model;

import java.util.List;

/**
 * This type represents a node for sql scripts
 * Created by kfgodel on 12/07/15.
 */
public class ScriptModel implements AgnosticModel {

  private List<AgnosticModel> statements;

  public List<AgnosticModel> getStatements() {
    return statements;
  }

  public static ScriptModel create(List<AgnosticModel> statements) {
    ScriptModel node = new ScriptModel();
    node.statements = statements;
    return node;
  }

  public void addStatement(AgnosticModel newStatement) {
    this.getStatements().add(newStatement);
  }

  @Override
  public String getTemplatePath() {
    return "/script/script.ftl";
  }
}
