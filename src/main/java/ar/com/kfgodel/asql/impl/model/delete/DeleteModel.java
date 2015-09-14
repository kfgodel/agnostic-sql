package ar.com.kfgodel.asql.impl.model.delete;

import ar.com.kfgodel.asql.impl.model.restrictions.WhereConstrainedModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;
import ar.com.kfgodel.asql.impl.model.where.WhereModel;

/**
 * This type represents the state of an agnostic delete statement
 * Created by kfgodel on 15/07/15.
 */
public class DeleteModel extends TableCenteredModel implements WhereConstrainedModel {

    private WhereModel whereClause;

    public static DeleteModel create(String tableName) {
        DeleteModel model = new DeleteModel();
        model.setTableName(tableName);
        model.whereClause = WhereModel.create();
        return model;
    }

    @Override
    public String getTemplatePath() {
        return "delete/delete.ftl";
    }

    @Override
    public WhereModel getWhereClause() {
        return whereClause;
    }
}
