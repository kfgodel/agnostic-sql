package ar.com.kfgodel.asql.impl.lang;

import ar.com.kfgodel.asql.impl.lang.internal.PatternHelper;
import ar.com.kfgodel.asql.impl.lang.internal.impl.PatternHelperImpl;

/**
 * This interface serves as an access point to internal API objects
 * without exposing the concrete class providing the implementation
 * Created by tenpines on 21/09/15.
 */
public interface Internal {

    static PatternHelper pattern() {
        return PatternHelperImpl.create();
    }
}
