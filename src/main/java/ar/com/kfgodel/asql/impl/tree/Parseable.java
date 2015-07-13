package ar.com.kfgodel.asql.impl.tree;

/**
 * This type represents an agnostic language piece that can be parsed into an agnostic model
 * Created by kfgodel on 12/07/15.
 */
public interface Parseable {

    /**
     * Generates a model that represents the abstract state of this language construct
     * @return The vendor independent model that can be used to generate vendor specific sql
     */
    AgnosticModel parseModel();

}
