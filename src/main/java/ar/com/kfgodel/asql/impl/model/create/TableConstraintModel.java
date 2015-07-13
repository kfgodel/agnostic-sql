package ar.com.kfgodel.asql.impl.model.create;

/**
 * This type represents the abstract model of a constraint delcared with the table
 * Created by kfgodel on 13/07/15.
 */
public class TableConstraintModel implements TablePartModel {
    private String declaration;

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public static TableConstraintModel create(String declaration) {
        TableConstraintModel model = new TableConstraintModel();
        model.declaration = declaration;
        return model;
    }

    @Override
    public boolean isColumnDeclaration() {
        return false;
    }
}
