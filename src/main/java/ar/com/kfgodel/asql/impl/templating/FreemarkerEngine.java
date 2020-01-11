package ar.com.kfgodel.asql.impl.templating;

import ar.com.kfgodel.asql.api.AsqlException;
import ar.com.kfgodel.nary.api.Nary;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This type represents the templating engine implemented with Freemarker
 * <p>
 * Created by kfgodel on 12/07/15.
 */
public class FreemarkerEngine implements TemplateEngine {

  private Configuration freemarkerConfig;

  public static FreemarkerEngine create(Nary<String> vendorSpecificDir) {
    FreemarkerEngine engine = new FreemarkerEngine();
    engine.initializeFor(vendorSpecificDir);
    return engine;
  }

  /**
   * Configures the templating engine to load templates first from the given vendor preferred dir
   *
   * @param templateLocations The vendor specific priority dir
   */
  private void initializeFor(Nary<String> templateLocations) {
    // Version is the latest as today 2015/07/10
    this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_22);
    // We use the classpath to load templates, with priority for the vendor templates and then ansi
    TemplateLoader[] templateLoaders = createLoadersFrom(templateLocations);
    MultiTemplateLoader mtl = new MultiTemplateLoader(templateLoaders);
    freemarkerConfig.setTemplateLoader(mtl);
    // Use UTF to read templates
    freemarkerConfig.setDefaultEncoding("UTF-8");
    // throw exception on any rendering error
    freemarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

  }

  private TemplateLoader[] createLoadersFrom(Nary<String> templateLocations) {
    return templateLocations
      .mapNary(templateLocation -> "/" + templateLocation + "/")
      .mapNary(classpathLocation -> new ClassTemplateLoader(getClass(), classpathLocation))
      .collect(Collectors.toList()).toArray(new TemplateLoader[0]);
  }

  @Override
  public String process(TemplateModel templateModel) throws AsqlException {
    try {
      Template template = loadTemplateFor(templateModel);

      StringWriter writer = new StringWriter();
      template.process(asModel(templateModel), writer);
      return writer.toString();
    } catch (AsqlException e) {
      throw e;
    } catch (Exception e) {
      throw new AsqlException("Unexpected error generating sql for[" + templateModel + "]", e);
    }
  }

  /**
   * Make the object available under the "model" variable (so it can nest with itself)
   *
   * @param templateModel The model to make available
   * @return The new root template model, with a reference to actual the model
   */
  private Map<String, Object> asModel(TemplateModel templateModel) {
    Map<String, Object> modelMap = new HashMap<>();
    modelMap.put("model", templateModel);
    return modelMap;
  }

  private Template loadTemplateFor(TemplateModel templateModel) throws IOException {
    String templateName = templateModel.getTemplatePath();
    try {
      return freemarkerConfig.getTemplate(templateName);
    } catch (TemplateNotFoundException e) {
      throw new AsqlException("The template[" + templateName + "] for model[" + templateModel + "] cannot be found on the classpath", e);
    }
  }
}
