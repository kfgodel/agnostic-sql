package ar.com.kfgodel.asql.impl.templating;

import ar.com.kfgodel.asql.impl.tree.TempletableNode;

/**
 * This type represents the knowledge of what template applies to which type
 * Created by kfgodel on 12/07/15.
 */
public interface TypeToTemplateMapper {

    /**
     * Returns the name of the template that must be used with the type of given object
     * @param templateModel The model to represent
     * @return The name identifying the template
     */
    String getTemplateNameFor(TempletableNode templateModel);
}
