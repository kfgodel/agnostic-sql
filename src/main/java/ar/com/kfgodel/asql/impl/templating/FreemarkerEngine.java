package ar.com.kfgodel.asql.impl.templating;

import ar.com.kfgodel.asql.api.AsqlException;
import ar.com.kfgodel.asql.impl.tree.TempletableNode;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * This type represents the templating engine implemented with Freemarker
 *
 * Created by kfgodel on 12/07/15.
 */
public class FreemarkerEngine implements TemplateEngine {

    private TypeToTemplateMapper typeMapper;
    private Configuration freemarkerConfig;

    public static FreemarkerEngine create(String vendorSepcificDir, TypeToTemplateMapper typeMapper) {
        FreemarkerEngine engine = new FreemarkerEngine();
        engine.typeMapper = typeMapper;
        engine.initializeFor(vendorSepcificDir);
        return engine;
    }

    /**
     * Configures the templating engine to load templates first from the given vendor preferred dir
     * @param priorityVendorDir The vendor specific priority dir
     */
    private void initializeFor(String priorityVendorDir) {
        // Version is the latest as today 2015/07/10
        this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_22);
        // We use the classpath to load templates, with priority for the vendor templates and then ansi
        ClassTemplateLoader vendorSpecificTemplates = new ClassTemplateLoader(getClass(), "/" + priorityVendorDir + "/");
        ClassTemplateLoader ansiTemplates = new ClassTemplateLoader(getClass(), "/ansi/");
        MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[] { vendorSpecificTemplates, ansiTemplates });
        freemarkerConfig.setTemplateLoader(mtl);
        // Use UTF to read templates
        freemarkerConfig.setDefaultEncoding("UTF-8");
        // throw exception on any rendering error
        freemarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    }

    @Override
    public String process(TempletableNode templateModel) throws AsqlException {
        try {
            Template template = loadTemplateFor(templateModel);

            StringWriter writer = new StringWriter();
            template.process(templateModel, writer);
            return writer.toString();
        } catch (AsqlException e){
            throw e;
        } catch (Exception e) {
            throw new AsqlException("Unexpected error generating sql for["+templateModel+"]",e);
        }
    }

    private Template loadTemplateFor(TempletableNode templateModel) throws IOException {
        String templateName = typeMapper.getTemplateNameFor(templateModel);
        try {
            return freemarkerConfig.getTemplate(templateName);
        } catch (TemplateNotFoundException e) {
            throw new AsqlException("The template["+templateName+"] for model["+templateModel+"] cannot be found on the classpath", e);
        }
    }
}
