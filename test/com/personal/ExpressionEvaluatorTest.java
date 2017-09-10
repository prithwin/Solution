package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/8/17.
 */
public class ExpressionEvaluatorTest {

    @Test
    public void testInfixToPostfixConversion(){
        System.out.println("\n( ( 23 + 24 ) * 35 - 56 ) * 33\n");
        new ExpressionEvaluator().infixToPostfix(getExpressionAsList("( ( 23 + 24 ) * 35 - 56 ) * 33")).stream().
                filter(s -> !s.equals("(")).forEach(i -> System.out.printf(" %s ", i));
    }

    private List<String> getExpressionAsList(String expression) {
        String[] expressionArray = expression.split("\\s");
        List<String> result = new ArrayList<>();
        for(String component : expressionArray) {
            result.add(component);
        }
        return result;
    }

    @Test public void testGetExpressionTree() {
        new ExpressionEvaluator().getExpressionTree(
                new ExpressionEvaluator().infixToPostfix(getExpressionAsList("( ( 23 + 24 ) * 35 - 56 ) * 33")))
                .printinOrder();
    }

    @Test public void testEvaluation() {
        System.out.println("\n((A+T)*((B+(A+C))^(C+D)))\n");
        List<String> postfix = new ExpressionEvaluator().infixToPostfix(new ExpressionEvaluator().lexp("25 + ( 30 + 78 * 45 ) + 34 * ( ( ( 45 * 76 ) + ( 34 / 2 ) ) * ( 11 + 100 ) ) / 1 + 30"));
        int val = 25 + ( 30 + 78 * 45 ) + 34 * ( ( ( 45 * 76 ) + ( 34 / 2 ) ) * ( 11 + 100 ) ) / 1 + 30;
        System.out.println(val);
        System.out.println(new ExpressionEvaluator().evaluate(postfix));
    }

}
