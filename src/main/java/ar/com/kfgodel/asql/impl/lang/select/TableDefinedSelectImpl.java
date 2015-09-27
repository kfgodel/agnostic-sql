package ar.com.kfgodel.asql.impl.lang.select;

import ar.com.kfgodel.asql.api.select.RestrictedSelect;
import ar.com.kfgodel.asql.api.select.TableDefinedSelect;
import ar.com.kfgodel.asql.impl.lang.Internal;
import ar.com.kfgodel.asql.impl.lang.references.TableReference;
import ar.com.kfgodel.asql.impl.model.references.TableReferenceModel;
import ar.com.kfgodel.asql.impl.model.select.FromModel;
import ar.com.kfgodel.asql.impl.model.select.SelectModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tenpines on 27/09/15.
 */
public class TableDefinedSelectImpl implements TableDefinedSelect {

    private ProjectionDefinedSelectImpl previousNode;
    private List<TableReference> tables;

    @Override
    public SelectModel parseModel() {
        SelectModel selectModel = previousNode.parseModel();
        selectModel.setFromClause(FromModel.create(parseTableModels()));
        return selectModel;
    }

    private List<TableReferenceModel> parseTableModels() {
        return tables.stream()
                .map(TableReference::parseModel)
                .collect(Collectors.toList());
    }

    public static TableDefinedSelectImpl create(ProjectionDefinedSelectImpl previousNode, List<TableReference> tables){
        TableDefinedSelectImpl select = new TableDefinedSelectImpl();
        select.previousNode = previousNode;
        select.tables = tables;
        return select;
    }

    @Override
    public RestrictedSelect where(Object condition) {
        return RestrictedSelectImpl.create(this, Internal.asConstruct(condition));
    }
}
