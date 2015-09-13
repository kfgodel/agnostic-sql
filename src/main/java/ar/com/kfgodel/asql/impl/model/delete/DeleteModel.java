package ar.com.kfgodel.asql.impl.model.delete;

import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;
import ar.com.kfgodel.asql.impl.model.restrictions.RowRestrictedModel;
import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * This type represents the state of an agnostic delete statement
 * Created by kfgodel on 15/07/15.
 */
public class DeleteModel extends TableCenteredModel implements RowRestrictedModel {

    private PredicateModel wherePredicate;


    public static DeleteModel create(String tableName) {
        DeleteModel model = new DeleteModel();
        model.setTableName(tableName);
        return model;
    }

    @Override
    public PredicateModel getWherePredicate() {
        return wherePredicate;
    }

    public void setWherePredicate(PredicateModel wherePredicate) {
        this.wherePredicate = wherePredicate;
    }

    @Override
    public String getTemplatePath() {
        return "delete/delete.ftl";
    }
}
