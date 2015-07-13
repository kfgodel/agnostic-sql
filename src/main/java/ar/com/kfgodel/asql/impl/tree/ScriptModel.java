package ar.com.kfgodel.asql.impl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This type represents a node for sql scripts
 * Created by kfgodel on 12/07/15.
 */
public class ScriptModel implements AgnosticModel {

    private List<String> statements;

    public List<String> getStatements() {
        if (statements == null) {
            statements = new ArrayList<String>();
        }
        return statements;
    }

    public static ScriptModel create() {
        ScriptModel node = new ScriptModel();
        return node;
    }

    public void addStatement(String newStatement) {
        this.getStatements().add(newStatement);
    }
}
