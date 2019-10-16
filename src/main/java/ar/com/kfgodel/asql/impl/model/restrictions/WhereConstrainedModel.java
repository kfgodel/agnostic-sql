package ar.com.kfgodel.asql.impl.model.restrictions;

import ar.com.kfgodel.asql.impl.model.where.WhereModel;

/**
 * This type represents a model for a statement that has restrictions over the rows
 * Created by kfgodel on 16/07/15.
 */
public interface WhereConstrainedModel {
  WhereModel getWhereClause();
}
