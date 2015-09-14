package ar.com.kfgodel.asql.impl.interpreter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.api.vendors.Vendor;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.templating.FreemarkerEngine;

/**
 * This type implements the vendor interpreter using templates for expressing vendor statements.<br>
 *     Due to freemarker performance, it's recommended to keep this instance alive for the entire application
 *     (instead of creating multiple instances)
 *
 * Created by kfgodel on 13/07/15.
 */
public class TemplateInterpreter implements VendorInterpreter {

    private FreemarkerEngine templateEngine;

    public static TemplateInterpreter create(Vendor vendor) {
        TemplateInterpreter interpreter = new TemplateInterpreter();
        interpreter.templateEngine = FreemarkerEngine.create(vendor.getTemplateLocationInClasspath());
        return interpreter;
    }

    @Override
    public String translate(AgnosticModel model) {
        return templateEngine.process(model);
    }

    @Override
    public String translate(AgnosticStatement statement) {
        return translate(statement.parseModel());
    }
}
