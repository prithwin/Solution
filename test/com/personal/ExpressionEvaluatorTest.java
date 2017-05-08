package com.personal;

import java.util.Arrays;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/8/17.
 */
public class ExpressionEvaluatorTest {

    @Test
    public void testInfixToPostixConversion(){
        new ExpressionEvaluator().infixToPostfix(Arrays.asList("(","(","23","+","24",")","*","35","-","56",")","*","33")).stream().
           filter(s -> !s.equals("(")).filter(s -> !s.equals(")")).forEach(i -> System.out.printf(" %s ",i));
    }

    @Test public void testGetExpressionTree() {
        new ExpressionEvaluator().getExpressionTree(new ExpressionEvaluator().infixToPostfix(Arrays.asList("(","(","23","+","24",")","*","35","-","56",")","*","33")))
            .printinOrder();
    }

    @Test public void testEvaluation() {
        System.out.println(new ExpressionEvaluator().evaluate(new ExpressionEvaluator().infixToPostfix(Arrays.asList("3","*","(","2","+","3",")"))));
    }

}
