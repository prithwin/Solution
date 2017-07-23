package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 7/16/17.
 */
public class LongestValidParentheses {
     public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max , i - stack.peek());
                }
            }
        }
        return max;
    }
}
