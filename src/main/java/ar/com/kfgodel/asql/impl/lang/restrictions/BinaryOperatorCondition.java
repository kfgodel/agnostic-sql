package ar.com.kfgodel.asql.impl.lang.restrictions;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.api.restrictions.QueryCondition;
import ar.com.kfgodel.asql.impl.model.restrictions.PredicateModel;

/**
 * This represents a binary operator expresion that takes a column as left operand and
 * another operand as right operand
 * Created by tenpines on 18/09/15.
 */
public class BinaryOperatorCondition implements QueryCondition {

    private AgnosticConstruct leftOperand;
    private String operatorSymbol;
    private AgnosticConstruct rightOperand;

    @Override
    public PredicateModel parseModel() {
        return PredicateModel.create(leftOperand.parseModel(), operatorSymbol, rightOperand.parseModel());
    }

    public static BinaryOperatorCondition create(AgnosticConstruct leftOperand, String operatorSymbol, AgnosticConstruct rightOperand){
        BinaryOperatorCondition lessCondition = new BinaryOperatorCondition();
        lessCondition.leftOperand = leftOperand;
        lessCondition.operatorSymbol = operatorSymbol;
        lessCondition.rightOperand = rightOperand;
        return lessCondition;
    }
    
}
