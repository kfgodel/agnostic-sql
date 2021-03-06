package ar.com.kfgodel.asql.impl.interpreter;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.interpreter.VendorInterpreter;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.templating.FreemarkerEngine;
import ar.com.kfgodel.nary.api.Nary;

/**
 * This type implements the vendor interpreter using templates for expressing vendor statements.<br>
 * Due to freemarker performance, it's recommended to keep this instance alive for the entire application
 * (instead of creating multiple instances)
 * <p>
 * Created by kfgodel on 13/07/15.
 */
public class TemplateInterpreter implements VendorInterpreter {

  private FreemarkerEngine templateEngine;

  public static TemplateInterpreter create(Nary<String> templateLocationsInClasspath) {
    TemplateInterpreter interpreter = new TemplateInterpreter();
    interpreter.templateEngine = FreemarkerEngine.create(templateLocationsInClasspath);
    return interpreter;
  }

  @Override
  public String translate(AgnosticModel model) {
    if (model == null) {
      throw new IllegalArgumentException("Need a model to translate, got null instead");
    }
    return templateEngine.process(model);
  }

  @Override
  public String translate(AgnosticConstruct construct) {
    AgnosticModel model = construct.parseModel();
    if (model == null) {
      throw new IllegalArgumentException("Parsed model can't be null. Generated from construct[" + construct + "]");
    }
    return translate(model);
  }
}
