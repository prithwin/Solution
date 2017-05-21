package com.personal.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by pr250155 on 5/21/17.
 */
public class StackADT {
    int[] backingArray;
    int top;

    public StackADT(int size) {
        this.backingArray = new int[size];
        top=-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int item) {
        if(top >= backingArray.length-1) {
            readjustArraySize();
        }
        backingArray[++top] = item;
    }

    public int pop() {
        if(top < 0 ) throw new EmptyStackException();
        return backingArray[top--];
    }

    public int peek() {
        return backingArray[top];
    }

    private void readjustArraySize() {
        this.backingArray = Arrays.copyOf(backingArray,backingArray.length +
                backingArray.length * (backingArray.length >> 1));
    }

    public static void reverseStackInPlace(StackADT stack) {
        if(stack.isEmpty()) return;
        int item = stack.pop();
        reverseStackInPlace(stack);
        addAtBottom(stack,item);
    }

    public static void addAtBottom(StackADT stackADT,int key){
        if(stackADT.isEmpty())
            {stackADT.push(key); return;}
        int item = stackADT.pop();
        addAtBottom(stackADT,key);
        stackADT.push(item);
    }

    public static void sortStack(StackADT stack){
        if(stack.isEmpty()){
            return;
        }
        int item = stack.pop();
        sortStack(stack);
        insertInCorrectPlace(stack,item);
    }

    public static void insertInCorrectPlace(StackADT stack, int key) {
        if(stack.isEmpty()) {stack.push(key);return;}
        if(stack.peek() > key) {
            int item = stack.pop();
            insertInCorrectPlace(stack,key);
            stack.push(item);
        } else {
            stack.push(key);
        }
    }

    public void printStack() {
        for(int i = 0 ; i<=top ; i++) {
            System.out.println(backingArray[i]);
        }
    }
}
