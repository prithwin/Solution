package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/8/17.
 */
public class FibonacciTest {
    @Test public void testNthFibonacci(){
        assertEquals(new Fibonacci().printNthFibonacciNumber(1),1);
        assertEquals(new Fibonacci().printNthFibonacciNumber(2),2);
        assertEquals(new Fibonacci().printNthFibonacciNumber(3),3);
        assertEquals(new Fibonacci().printNthFibonacciNumber(4),5);
        assertEquals(new Fibonacci().printNthFibonacciNumber(5),8);
    }

    @Test public void testPrintFicbonacciSequnce() {
        new Fibonacci().printFibonacciNumbers(10);
    }

    @Test public void testPrintFicbonacciSequnce2() {
        new Fibonacci().fibonacciRecursive(10);
    }


}
