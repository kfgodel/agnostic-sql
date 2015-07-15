package ar.com.kfgodel.asql.impl.templating.mapper;

import ar.com.kfgodel.asql.impl.templating.TemplateReferable;

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
    String getTemplateNameFor(TemplateReferable templateModel);
}
