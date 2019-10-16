package ar.com.kfgodel.asql.impl.templating;

/**
 * This type represents a sql agnostic node that can be represented with a template
 * Created by kfgodel on 12/07/15.
 */
public interface TemplateModel {
  /**
   * @return The classpath relative path for the template that constructs a vendor specific language piece
   */
  String getTemplatePath();
}
