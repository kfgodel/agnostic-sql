package ar.com.kfgodel.asql.impl.lang.internal.impl;

import ar.com.kfgodel.asql.impl.lang.internal.PatternHelper;

/**
 * Created by tenpines on 21/09/15.
 */
public class PatternHelperImpl implements PatternHelper {

    public static final String ANY_OPTIONAL_STRING = "%";

    public static PatternHelperImpl create(){
        PatternHelperImpl helper = new PatternHelperImpl();
        return helper;
    }

    @Override
    public String contains(String substring) {
        return ANY_OPTIONAL_STRING + substring + ANY_OPTIONAL_STRING;
    }

    @Override
    public String endsWith(String suffix) {
        return ANY_OPTIONAL_STRING + suffix;
    }

    @Override
    public String startsWith(String prefix) {
        return prefix + ANY_OPTIONAL_STRING;
    }
}
