package ar.com.kfgodel.asql.api.indices;

/**
 * Created by tenpines on 27/09/15.
 */
public interface NameDefinedDropIndex  {

    DropIndexStatement from(String tableName);
}
