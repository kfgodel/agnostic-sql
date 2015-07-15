package ar.com.kfgodel.asql.impl.model.restrictions;

import ar.com.kfgodel.asql.impl.model.AgnosticModel;

/**
 * This type represents a predicate condition node in the statement tree
 * Created by kfgodel on 12/07/15.
 */
public class PredicateModel implements AgnosticModel {

    private Object leftSideOperand;
    private String operator;
    private Object rightSideOperand;

    public Object getLeftSideOperand() {
        return leftSideOperand;
    }

    public void setLeftSideOperand(Object leftSideOperand) {
        this.leftSideOperand = leftSideOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getRightSideOperand() {
        return rightSideOperand;
    }

    public void setRightSideOperand(Object rightSideOperand) {
        this.rightSideOperand = rightSideOperand;
    }

    public static PredicateModel create(Object left, String operator, Object right) {
        PredicateModel node = new PredicateModel();
        node.leftSideOperand = left;
        node.operator = operator;
        node.rightSideOperand = right;
        return node;
    }

}
