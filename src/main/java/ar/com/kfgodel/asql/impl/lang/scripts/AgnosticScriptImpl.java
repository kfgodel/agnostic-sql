package ar.com.kfgodel.asql.impl.lang.scripts;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.scripts.AgnosticScript;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.ScriptModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tenpines on 23/09/15.
 */
public class AgnosticScriptImpl implements AgnosticScript {
    private List<AgnosticStatement> statements;

    @Override
    public List<AgnosticStatement> getStatements() {
        return statements;
    }

    @Override
    public AgnosticModel parseModel() {
        return ScriptModel.create(parseStatementModels());
    }

    private List<AgnosticModel> parseStatementModels() {
        return statements.stream()
                .map(AgnosticStatement::parseModel)
                .collect(Collectors.toList());
    }
    
    public static AgnosticScriptImpl create(List<AgnosticStatement> statements){
        AgnosticScriptImpl script = new AgnosticScriptImpl();
        script.statements = statements;
        return script;
    }
    
}
