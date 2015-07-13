package ar.com.kfgodel.asql.api.condition;

/**
 * Created by kfgodel on 11/07/15.
 */
public interface NamedColumn {

    QueryCondition isNull();

    QueryCondition isNotNull();
}
