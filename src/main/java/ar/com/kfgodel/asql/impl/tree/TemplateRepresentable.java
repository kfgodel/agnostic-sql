package ar.com.kfgodel.asql.impl.tree;

/**
 * This type represents an element that can be representes with a template and a representation node that captures
 * its state
 * Created by kfgodel on 12/07/15.
 */
public interface TemplateRepresentable {

    /**
     * @return The information node that captures this statement configuration state
     */
    TemplateUsable getRepresentationNode();

}
