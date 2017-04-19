package ar.com.kfgodel.asql.impl.lang.custom;

import ar.com.kfgodel.asql.api.custom.CustomConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.custom.CustomSqlModel;

/**
 * this class holds the custom piece of sql
 * Created by dario.garcia on 19/04/17.
 */
public class CustomConstructImpl implements CustomConstruct {

  private String translatedSql;

  @Override
  public AgnosticModel parseModel() {
    return CustomSqlModel.create(translatedSql);
  }

  public static CustomConstructImpl create(String translatedSql) {
    CustomConstructImpl construct = new CustomConstructImpl();
    construct.translatedSql = translatedSql;
    return construct;
  }

}
