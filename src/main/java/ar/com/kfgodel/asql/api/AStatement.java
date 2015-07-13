package ar.com.kfgodel.asql.api;

import ar.com.kfgodel.asql.impl.tree.TemplateRepresentable;
import ar.com.kfgodel.asql.impl.tree.TemplateUsable;

/**
 * This type represents a vendor agnostic sql statement
 * Created by kfgodel on 11/07/15.
 */
public interface AStatement extends TemplateRepresentable {
    /**
     * @return The information node that captures this statement configuration state
     */
    TemplateUsable getRepresentationNode();
}
