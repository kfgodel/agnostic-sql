package ar.com.kfgodel.asql.impl.model.drop;

import ar.com.kfgodel.asql.impl.model.support.TableCenteredModel;

/**
 * Created by kfgodel on 15/07/15.
 */
public class DropModel extends TableCenteredModel {

    public static DropModel create(String tableName) {
        DropModel model = new DropModel();
        model.setTableName(tableName);
        return model;
    }

}
