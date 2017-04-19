package ar.com.kfgodel.asql.impl.model.custom;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This class represents a customly defined sql piece
 * Created by dario.garcia on 19/04/17.
 */
public class CustomSqlModel implements AgnosticModel {

  private String translatedSql;

  public String getTranslatedSql() {
    return translatedSql;
  }

  @Override
  public String getTemplatePath() {
    return "/custom/_construct.ftl";
  }

  public static CustomSqlModel create(String translatedSql) {
    CustomSqlModel model = new CustomSqlModel();
    model.translatedSql = translatedSql;
    return model;
  }

}
