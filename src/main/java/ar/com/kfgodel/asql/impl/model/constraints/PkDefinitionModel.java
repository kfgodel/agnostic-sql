package ar.com.kfgodel.asql.impl.model.constraints;

import ar.com.kfgodel.asql.impl.model.references.ColumnReferenceModel;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by tenpines on 22/09/15.
 */
public class PkDefinitionModel implements ConstraintDefinitionModel {

    private List<ColumnReferenceModel> columns;

    public List<ColumnReferenceModel> getColumns() {
        return columns;
    }
    
    public static PkDefinitionModel create(ColumnReferenceModel column){
        PkDefinitionModel model = new PkDefinitionModel();
        model.columns = Lists.newArrayList(column);
        return model;
    }
    

    @Override
    public String getTemplatePath() {
        return "/constraints/_pkDefinition.ftl";
    }
}
