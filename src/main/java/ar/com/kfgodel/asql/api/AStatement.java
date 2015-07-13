package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.impl.tree.TempletableNode;

/**
 * This type represents a vendor agnostic sql statement
 * Created by kfgodel on 11/07/15.
 */
public interface AStatement {
    /**
     * @return The information node that captures this statement configuration state
     */
    TempletableNode getRepresentationNode();
}
