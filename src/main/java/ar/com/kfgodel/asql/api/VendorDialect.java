package ar.com.kfgodel.asql.api;

import java.util.List;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface VendorDialect {
    String translate(AStatement statement);
    String translate(List<AStatement> statements);
}
