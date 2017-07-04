package com.personal;

import com.personal.util.StackADT;
import org.testng.annotations.*;

import java.util.EmptyStackException;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/21/17.
 */
public class StackTest {
    @Test(expectedExceptions = EmptyStackException.class) public void testStack() {
        StackADT stack = new StackADT(3);
        for(int i = 1 ; i < 100 ; i++) {
            stack.push(i);
        }

        for(int i = 1 ; i < 100 ; i++) {
            stack.pop();
        }
        stack.pop();
    }
    @Test public void testStackReversal() {
        StackADT stackADT = new StackADT(3);
        for(int i = 1 ; i < 6 ; i++) {
            stackADT.push(i);
        }
        StackADT.reverseStackInPlace(stackADT);
        stackADT.printStack();
    }


    @Test public void testStackSort() {
        StackADT stackADT = new StackADT(3);
        stackADT.push(3);
        stackADT.push(45);
        stackADT.push(6);
        stackADT.push(98);
        stackADT.push(1);
        StackADT.sortStack(stackADT);
        stackADT.printStack();
    }
}
