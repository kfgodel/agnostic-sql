package ar.com.kfgodel.asql.api.custom;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;

/**
 * This type represents a custom piece of sql and therefore can be anything that's needed
 * on statements
 * <p>
 * Created by dario.garcia on 19/04/17.
 */
public interface CustomConstruct extends AgnosticStatement, QueryCondition {
}
