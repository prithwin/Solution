package com.personal.dynamicprogramming;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 8/5/17.
 */
public class LargestSquareCompleteMatrixTest {
    @Test
    public void testMaximalSquare() throws Exception {
        char[][] src =  {{'0', '1','1', '0', '1'},
                        {'1', '1', '0', '1', '0'},
                        {'0', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '1'},
                        {'0', '0', '0', '0', '0'}};
        System.out.println(new LargestSquareCompleteMatrix().maximalSquare(src));
    }

    @Test
    public void testMaximalSquare1() throws Exception {
        char[][] src =  {{'1', '1','1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'}};
        System.out.println(new LargestSquareCompleteMatrix().maximalSquare(src));
    }

    //["10100","10111","11111","11111"]

    @Test
    public void testMaximalSquare2() throws Exception {
        char[][] src =  {{'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'}};
        System.out.println(new LargestSquareCompleteMatrix().maximalSquare(src));
    }

}