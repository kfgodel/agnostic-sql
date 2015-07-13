package ar.com.kfgodel.asql.impl.interpreter;

import ar.com.kfgodel.asql.api.Vendor;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.impl.templating.DefaultTypeMapper;
import ar.com.kfgodel.asql.impl.templating.FreemarkerEngine;
import ar.com.kfgodel.asql.impl.tree.AgnosticModel;

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
        interpreter.templateEngine = FreemarkerEngine.create(vendor.getTemplateLocationInClasspath(), DefaultTypeMapper.create());
        return interpreter;
    }

    @Override
    public String translate(AgnosticModel updateModel) {
        return templateEngine.process(updateModel);
    }
}
