package ar.com.kfgodel.asql.api.condition;

import ar.com.kfgodel.asql.impl.tree.PredicateNode;
import ar.com.kfgodel.asql.impl.tree.TemplateRepresentable;

/**
 * This type represents the definition of an agnostic restriction/condition
 * Created by kfgodel on 11/07/15.
 */
public interface QueryCondition extends TemplateRepresentable {

    @Override
    PredicateNode getRepresentationNode();
}
