package ar.com.kfgodel.asql.impl.model.constraints;

import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;

import java.util.List;

/**
 * Created by tenpines on 22/09/15.
 */
public class PkDefinitionModel implements ConstraintDefinitionModel {

    private List<ColumnReferenceModel> columns;

    public List<ColumnReferenceModel> getColumns() {
        return columns;
    }
    
    public static PkDefinitionModel create(List<ColumnReferenceModel> columns){
        PkDefinitionModel model = new PkDefinitionModel();
        model.columns = columns;
        return model;
    }
    

    @Override
    public String getTemplatePath() {
        return "/constraints/_pkDefinition.ftl";
    }
}
