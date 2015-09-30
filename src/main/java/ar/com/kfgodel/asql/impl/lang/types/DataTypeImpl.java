package ar.com.kfgodel.asql.impl.lang.types;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.types.DataType;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.types.DataTypeModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kfgodel on 13/07/15.
 */
public class DataTypeImpl implements DataType {

    private String name;
    private List<AgnosticConstruct> arguments;

    public List<AgnosticConstruct> getArguments() {
        return arguments;
    }

    public String getAgnosticName() {
        return name;
    }

    public static DataTypeImpl create(String name, List<AgnosticConstruct> arguments) {
        DataTypeImpl type = new DataTypeImpl();
        type.name = name;
        type.arguments = arguments;
        return type;
    }

    @Override
    public DataTypeModel parseModel() {
        return DataTypeModel.create(getAgnosticName(), parseArgumentModels());
    }

    private List<AgnosticModel> parseArgumentModels() {
        return getArguments().stream()
                .map(AgnosticConstruct::parseModel)
                .collect(Collectors.toList());
    }
}
