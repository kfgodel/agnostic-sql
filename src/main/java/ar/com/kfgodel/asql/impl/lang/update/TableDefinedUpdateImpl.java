package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.columns.ColumnAssignment;
import ar.com.kfgodel.asql.api.update.TableDefinedUpdate;
import ar.com.kfgodel.asql.api.update.UnrestrictedUpdate;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.lang.support.TableCenteredStatement;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by kfgodel on 12/07/15.
 */
public class TableDefinedUpdateImpl extends TableCenteredStatement implements TableDefinedUpdate {

    public static TableDefinedUpdateImpl create(TableReference table) {
        TableDefinedUpdateImpl update = new TableDefinedUpdateImpl();
        update.setTable(table);
        return update;
    }

    @Override
    public UnrestrictedUpdate setting(ColumnAssignment... assignments) {
        if(assignments == null || assignments.length == 0){
            throw new IllegalArgumentException("At least one assignment needed");
        }
        List<ColumnAssignment> list = Lists.newArrayList(assignments);
        return UnrestrictedUpdateImpl.create(this, list);
    }

}
