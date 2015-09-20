package ar.com.kfgodel.asql.impl.model.restrictions;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;
import ar.com.kfgodel.asql.impl.model.value.ExplicitOperand;

/**
 * This type represents a predicate condition node in the statement tree
 * Created by kfgodel on 12/07/15.
 */
public class PredicateModel implements AgnosticModel, ExplicitOperand {

    private AgnosticModel leftSideOperand;
    private AgnosticModel operator;
    private AgnosticModel rightSideOperand;

    public AgnosticModel getLeftSideOperand() {
        return leftSideOperand;
    }

    public void setLeftSideOperand(AgnosticModel leftSideOperand) {
        this.leftSideOperand = leftSideOperand;
    }

    public AgnosticModel getOperator() {
        return operator;
    }

    public void setOperator(AgnosticModel operator) {
        this.operator = operator;
    }

    public AgnosticModel getRightSideOperand() {
        return rightSideOperand;
    }

    public void setRightSideOperand(AgnosticModel rightSideOperand) {
        this.rightSideOperand = rightSideOperand;
    }

    public static PredicateModel create(AgnosticModel left, AgnosticModel operator, AgnosticModel right) {
        PredicateModel node = new PredicateModel();
        node.leftSideOperand = left;
        node.operator = operator;
        node.rightSideOperand = right;
        return node;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public String getTemplatePath() {
        return "/where/_predicate.ftl";
    }
}
