package ar.com.kfgodel.asql.impl.model.delete;

import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * This type represents the state of an agnostic delete statement
 * Created by kfgodel on 15/07/15.
 */
public class DeleteModel extends TableCenteredModel {

    public static DeleteModel create(String tableName) {
        DeleteModel model = new DeleteModel();
        model.setTableName(tableName);
        return model;
    }

}
