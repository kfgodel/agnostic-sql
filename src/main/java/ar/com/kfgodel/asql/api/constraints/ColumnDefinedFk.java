package ar.com.kfgodel.asql.api.constraints;

/**
 * This type represents a constraint applied over columns
 * Created by kfgodel on 16/07/15.
 */
public interface ColumnDefinedFk {
    FkConstraintDeclaration to(String referencedTableName);
}
