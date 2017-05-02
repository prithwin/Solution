package com.personal;

import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;

import java.util.*;

/**
 * Created by pr250155 on 5/1/17.
 * A + B + C
 */
public class ExpressionEvaluator {

    Map<String,Integer> operandPriority = getOperandTable();

    private Map<String, Integer> getOperandTable() {
        Map<String,Integer> operands = new HashMap();
        operands.put("/",1);
        operands.put("*",2);
        operands.put("+",3);
        operands.put("-",3);
        return operands;
    }

    public int evaluate(List<String> postfix) {
        Stack<String> evaluationStack = new Stack<>();
        for(String item : postfix) {
            if(isNumeric(item)){
                evaluationStack.push(item);
            } else {
                if(item.equals("(") || item.equals(")")) continue;
                int result = 0;
                String b = evaluationStack.pop();
                String a = evaluationStack.pop();
                result = applyOpeator(a,b,item);
                evaluationStack.push(result+"");
            }
        }
        return Integer.parseInt(evaluationStack.pop());
    }

    private int applyOpeator(String a, String b, String operator) {
        int temp = 0;
        switch (operator) {
            case "+" :
                temp = Integer.parseInt(a) + Integer.parseInt(b); return temp;

            case "-" :
                temp = Integer.parseInt(a) - Integer.parseInt(b); return temp;

            case "*" :
                temp = Integer.parseInt(a) * Integer.parseInt(b); return temp;

            case "/" :
                temp = Integer.parseInt(a) / Integer.parseInt(b); return temp;

        }
        return 0;
    }

    public BinaryTree getExpressionTree(List<String> postfix) {

        Stack<TreeNode> expressionStack = new Stack<>();
        Stack<String> traversalStack = new Stack<>();
        BinaryTree result = new BinaryTree();

        for(int i = 0 ; i < postfix.size() ; i++) {
            String item = postfix.get(i);
            if(item.equals("(") || item.equals(")")){
                continue;
            }
            if(isNumeric(item)) {
                TreeNode node = new TreeNode(Integer.parseInt(item));
                expressionStack.push(node);
            } else {
                TreeNode r = expressionStack.pop();
                TreeNode l = expressionStack.pop();
                TreeNode operator = new TreeNode(item);
                operator.left = l;
                operator.right = r;
                expressionStack.push(operator);
            }
        }
        result.root = expressionStack.pop();
        return result;

    }

    public List<String> infixToPostfix(List<String> infix){

        Stack<String> operandStack = new Stack<>();
        List<String> postfix = new ArrayList<>();
        for(int i = 0 ; i < infix.size() ; i++) {
            String item = infix.get(i);
            if(item.equals("(")){
                operandStack.push(item);
                continue;
            }
            if(item.equals(")")) {
                while(true) {
                    if(operandStack.isEmpty()) break;
                    String stackedItem = operandStack.pop();
                    postfix.add(stackedItem);
                    if(stackedItem.equals("(")) {
                        postfix.add(")");
                        break;
                    }
                }
                continue;
            }
            if(isNumeric(item)) {
                postfix.add(item);
            } else {
                if(isHigherPrescedence(operandStack,item)){
                    operandStack.push(item);
                } else {
                  while (!isHigherPrescedence(operandStack,item)){
                      postfix.add(operandStack.pop());
                  }
                  operandStack.push(item);
                }
            }

        }
        while(!operandStack.isEmpty()) {
            postfix.add(operandStack.pop());
        }
        return postfix;
    }

    private boolean isNumeric(String item) {
        return item.matches("[0-9]+");
    }

    private boolean isHigherPrescedence(Stack<String> operandStack , String operator){
        if(operandStack.isEmpty()){
            return true;
        }
        if(operandStack.peek().equals("(")){
            return true;
        }
        if(operandPriority.get(operandStack.peek()) > operandPriority.get(operator)){
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
//        new ExpressionEvaluator().infixToPostfix(Arrays.asList("(","(","23","+","24",")","*","35","-","56",")","*","33")).stream().
//               filter(s -> !s.equals("(")).filter(s -> !s.equals(")")).forEach(i -> System.out.printf(" %s ",i));
//
//        new ExpressionEvaluator().infixToPostfix(Arrays.asList("1","*","(","2","+","3",")")).stream().
//                filter(s -> !s.equals("(")).filter(s -> !s.equals(")")).forEach(i -> System.out.printf(" %s ", i));
//
//        System.out.println(new ExpressionEvaluator().evaluate(new ExpressionEvaluator().infixToPostfix(Arrays.asList("3","*","(","2","+","3",")"))));
        new ExpressionEvaluator().
                getExpressionTree(new ExpressionEvaluator().infixToPostfix(Arrays.asList("(","(","23","+","24",")","*","35","-","56",")","*","33")))
                .printinOrder();
    }
}
