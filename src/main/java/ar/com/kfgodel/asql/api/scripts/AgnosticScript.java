package ar.com.kfgodel.asql.api.scripts;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.AgnosticStatement;

import java.util.List;

/**
 * This type represents an agnostic script. A vendor independent set of statements
 * Created by tenpines on 23/09/15.
 */
public interface AgnosticScript extends AgnosticConstruct {

    List<AgnosticStatement> getStatements();
}
