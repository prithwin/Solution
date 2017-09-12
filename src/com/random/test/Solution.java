package com.random.test;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by prajeeva on 9/11/17.
 */
class MinStack {

    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
        minStack.add(0);

    }

    public void push(int x) {
        if(x < minStack.get(minStack.size() -1)) {
            minStack.add(x);
        }
        stack.add(x);
    }

    public void pop() {
        if(stack.size() > 0) {
            int numRemoved = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if(minStack.get(minStack.size() - 1) == numRemoved) {
                minStack.remove(minStack.size() - 1);
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }


}

public class Solution {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(0);
        s.push(1);
        s.push(0);
        s.getMin();
        s.pop();
        s.getMin();
    }
}