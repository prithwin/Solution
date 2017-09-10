package com.personal;

import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;

import java.util.*;

/**
 * Created by pr250155 on 5/1/17.
 * A + B + C
 */
public class ExpressionEvaluator {

    public static final String LEFT_PARENTHESES = "(";
    public static final String RIGHT_PARENTHESES = ")";
    Map<String,Integer> operandPriority = getOperandTable();

    private Map<String, Integer> getOperandTable() {
        Map<String,Integer> operands = new HashMap();
        operands.put("/",1);
        operands.put("*",2);
        operands.put("+",3);
        operands.put("-",3);
        return operands;
    }

    public List<String> lexp(String expression) {
        List<String> response = new ArrayList<>();
        Queue<Character> operandStack = new LinkedList<>();
        char[] expressionCharArray = expression.toCharArray();
        for (int i = 0; i < expressionCharArray.length; i++) {
            char c = expressionCharArray[i];
            if (c == ' ') {
                emptyStack(operandStack , response);
            } else if (isArithmaticOperator(c)) {
                emptyStack(operandStack , response);
                response.add(c + "");
            } else if (isGreaterThanOrLessThan(c)) {
                emptyStack(operandStack , response);
                char n = expressionCharArray[i+1];
                if(isCompoundOperatorComponent(n)) {
                    response.add(c+""+n);i++;
                }
                response.add(c+"");
            } else {
                operandStack.offer(c);
            }
        }
        emptyStack(operandStack , response);
        return response;
    }
    private void emptyStack(Queue<Character> queue , List<String> target) {
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        if(sb.toString().equals("")) return;
        target.add(sb.toString());
    }

    private boolean isGreaterThanOrLessThan(char c) {
        if(c == '<' || c == '>') return true;
        return false;
    }

    private boolean isArithmaticOperator(char c) {
        if(c == '+' || c == '-' || c == '/' || c == '*' || c == '|' || c == '&' || c == '(' || c == ')')
            return true;
        return false;
    }

    private boolean isCompoundOperatorComponent(char c) {
        if(c == '=' || c == '>') return true;
        return false;
    }

    public int evaluate(List<String> postfix) {
        Stack<String> evaluationStack = new Stack<>();
        for(String item : postfix) {
            if(isNumeric(item)){
                evaluationStack.push(item);
            } else {
                int result;
                String b = evaluationStack.pop();
                String a = evaluationStack.pop();
                result = applyOpeator(a,b,item);
                evaluationStack.push(Integer.toString(result));
            }
        }
        return Integer.parseInt(evaluationStack.pop());
    }

    private int applyOpeator(String a, String b, String operator) {
        int temp;
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
        BinaryTree result = new BinaryTree();

        for(int i = 0 ; i < postfix.size() ; i++) {
            String item = postfix.get(i);
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
        operandStack.push(LEFT_PARENTHESES);
        infix.add(RIGHT_PARENTHESES);
        int i = 0;
        while(!operandStack.isEmpty()) {
            String item = infix.get(i);
            if(item.equals(LEFT_PARENTHESES)) {
                operandStack.push(item);
            } else if(isNumeric(item)) {
                postfix.add(item);
            } else if(isOperator(item)) {
                while(!isSameOrHigherPrecedence(operandStack,item)) {
                    postfix.add(operandStack.pop());
                }
                operandStack.push(item);

            } else {
                while(true) {
                    String operand = operandStack.pop();
                    if(operand.equals(LEFT_PARENTHESES)) break;
                    postfix.add(operand);
                }
            }
            i++;
        }
        return postfix;
    }

    private boolean isOperator(String item) {
        if(operandPriority.containsKey(item)) return true;
        return false;
    }

    private boolean isNumeric(String item) {
        return item.matches("[0-9]+");
    }

    private boolean isSameOrHigherPrecedence(Stack<String> operandStack , String operator){

        if(operandStack.peek().equals(LEFT_PARENTHESES)){
            return true;
        }
        if(operandPriority.get(operandStack.peek()) >= operandPriority.get(operator)){
            return true;
        }
        return false;

    }
}
