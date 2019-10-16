package ar.com.kfgodel.asql.impl.lang.internal;

/**
 * This type helps expressing text patterns used in sql queries
 * Created by tenpines on 21/09/15.
 */
public interface PatternHelper {

  String contains(String substring);

  String endsWith(String suffix);

  String startsWith(String prefix);
}
