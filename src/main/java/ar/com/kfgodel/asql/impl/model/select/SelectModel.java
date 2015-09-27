package ar.com.kfgodel.asql.impl.model.select;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

import java.util.List;

/**
 * Created by tenpines on 23/09/15.
 */
public class SelectModel implements AgnosticModel {

    private List<AgnosticModel> projections;
    private FromModel fromClause;

    public FromModel getFromClause() {
        return fromClause;
    }

    public void setFromClause(FromModel fromClause) {
        this.fromClause = fromClause;
    }

    public List<AgnosticModel> getProjections() {
        return projections;
    }

    @Override
    public String getTemplatePath() {
        return "/select/select.ftl";
    }
    
    public static SelectModel create(List<AgnosticModel> projections){
        SelectModel selectModel = new SelectModel();
        selectModel.projections = projections;
        return selectModel;
    }
    
}
