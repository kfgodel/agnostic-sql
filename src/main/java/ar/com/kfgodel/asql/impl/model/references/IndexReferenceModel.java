package ar.com.kfgodel.asql.impl.model.references;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents the reference to an index
 * Created by tenpines on 27/09/15.
 */
public class IndexReferenceModel implements AgnosticModel {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String getTemplatePath() {
        return "/references/_index.ftl";
    }

    public static IndexReferenceModel create(String name){
        IndexReferenceModel model = new IndexReferenceModel();
        model.name = name;
        return model;
    }

}
