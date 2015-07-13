package ar.com.kfgodel.asql.api.interpreter;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

import java.util.List;

/**
 * This type represents the translator of agnostic statements to vendor specific sql
 * Created by kfgodel on 13/07/15.
 */
public interface VendorInterpreter {

    /**
     * Generates a vendor specific sql text that can be used on the database
     * @param updateModel The abstract model of the desired statement
     * @return The vendor specific sql
     */
    String translate(AgnosticModel updateModel);

    String translate(List<AgnosticModel> modelList);

    String translate(AgnosticStatement statement);

}
