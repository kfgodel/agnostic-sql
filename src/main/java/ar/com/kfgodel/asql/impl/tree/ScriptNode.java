package ar.com.kfgodel.asql.impl.tree;

import ar.com.kfgodel.asql.impl.templating.TemplateReferable;

import java.util.ArrayList;
import java.util.List;

/**
 * This type represents a node for sql scripts
 * Created by kfgodel on 12/07/15.
 */
public class ScriptNode implements TemplateReferable {

    private List<String> statements;

    public List<String> getStatements() {
        if (statements == null) {
            statements = new ArrayList<String>();
        }
        return statements;
    }

    public static ScriptNode create() {
        ScriptNode node = new ScriptNode();
        return node;
    }

    public void addStatement(String newStatement) {
        this.getStatements().add(newStatement);
    }
}
