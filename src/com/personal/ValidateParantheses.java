package com.personal;

import java.util.Stack;

/**
 * Created by prajeev on 15/7/16.
 */
public class ValidateParantheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c=='[' || c=='{') {
                 stack.push(c);
            } else {
                if(!stack.isEmpty() && isClosingBrace(c,stack.peek()))
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isClosingBrace(Character c , Character peek) {
        if(peek == '(' && c == ')')
            return true;

        if(peek == '[' && c == ']')
            return true;


        if(peek == '{' && c == '}')
            return true;
        return false;

    }

    public static void main(String[] args){
       System.out.println(new ValidateParantheses().isValid("(({((()))}))"));
    }
}
