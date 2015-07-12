package ar.com.kfgodel.asql.api;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface VendorDialect {
    String translate(AStatement statement);
}
