package ar.com.kfgodel.asql.impl.lang.update;

import ar.com.kfgodel.asql.api.condition.QueryCondition;
import ar.com.kfgodel.asql.api.update.RestrictedUpdate;
import ar.com.kfgodel.asql.impl.tree.TemplateUsable;
import ar.com.kfgodel.asql.impl.tree.UpdateNode;

/**
 * Created by kfgodel on 12/07/15.
 */
public class RestrictedUpdateImpl implements RestrictedUpdate {

    private UnrestrictedUpdateImpl unrestrictedUpdate;
    private QueryCondition condition;

    @Override
    public TemplateUsable getRepresentationNode() {
        UpdateNode updateNode = unrestrictedUpdate.getRepresentationNode();
        updateNode.setWherePredicate(condition.getRepresentationNode());
        return updateNode;
    }

    public static RestrictedUpdateImpl create(UnrestrictedUpdateImpl unrestrictedUpdate, QueryCondition condition) {
        RestrictedUpdateImpl update = new RestrictedUpdateImpl();
        update.condition = condition;
        update.unrestrictedUpdate = unrestrictedUpdate;
        return update;
    }

}
