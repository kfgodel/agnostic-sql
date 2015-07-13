package ar.com.kfgodel.asql.impl.templating;

import ar.com.kfgodel.asql.api.AsqlException;
import ar.com.kfgodel.asql.impl.tree.TempletableNode;

/**
 * This type represents the interface with the underlying template engine
 * Created by kfgodel on 12/07/15.
 */
public interface TemplateEngine {

    /**
     * According to the model type it selects a template to apply using the model state.<br>
     *     It generates a text based on the model state.
     *
     * @param templateModel The model whose state is used with the template, and whose type is used to select the template
     * @return The generated text
     * @throws AsqlException If the engine found an error processing the template
     */
    String process(TempletableNode templateModel) throws AsqlException;
}
