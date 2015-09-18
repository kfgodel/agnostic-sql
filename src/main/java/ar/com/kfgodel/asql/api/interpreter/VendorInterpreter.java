package ar.com.kfgodel.asql.api.interpreter;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.AgnosticModel;

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

    /**
     * Facility method that translates the agnostic construction into this vendor specific
     * language
     * @param construct The agnostically expressed language construct
     * @return The vendor specific equivalent
     */
    String translate(AgnosticConstruct construct);

}
