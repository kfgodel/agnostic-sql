package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitValueModel;
import ar.com.kfgodel.asql.impl.model.value.ValueListModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This type represents a language reference to a value list literal
 * Created by tenpines on 19/09/15.
 */
public class ListLiteralReference implements AgnosticConstruct {

    private Collection<?> values;

    public static ListLiteralReference create(Collection<?> values){
        ListLiteralReference listReference = new ListLiteralReference();
        listReference.values = values;
        return listReference;
    }

    @Override
    public AgnosticModel parseModel() {
        return ValueListModel.create(parseValueModels());
    }

    private List<AgnosticModel> parseValueModels() {
        List<AgnosticModel> parsedValues = values.stream()
                .map(ExplicitValueModel::create)
                .collect(Collectors.toList());
        return parsedValues;
    }

}
