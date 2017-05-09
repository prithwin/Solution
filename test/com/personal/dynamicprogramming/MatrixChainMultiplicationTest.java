package com.personal.dynamicprogramming;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/9/17.
 */

public class MatrixChainMultiplicationTest {
    @Test public void findMinCost4Matrices() {
        int[][] input = {{2,3},{3,6},{6,4},{4,5}};
        int response = new MatrixChainMultiplication().findMinimumCost(input);
        System.out.println(response);
    }

    @Test public void findMinCost6Matrices() {
        int[][] input = {{30,35},{35,15},{15,5},{5,10},{10,20},{20,25}};
        int response = new MatrixChainMultiplication().findMinimumCost(input);
        System.out.println(response);
    }
}
