package com.personal.dynamicprogramming;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/17/17.
 */
public class SubsetSumProblemTest {
    @Test public void testSum() {
        int[] target = {2,3,7,8,10};
        assertTrue(new SubsetSumProblem().isSumPossibleR(target,11));
        assertTrue(new SubsetSumProblem().isSumPossibleR(target,10));
        assertTrue(new SubsetSumProblem().isSumPossibleR(target,5));
        assertFalse(new SubsetSumProblem().isSumPossibleR(target,35));
        assertTrue(new SubsetSumProblem().isSumPossibleR(target,12));
    }

    @Test public void testSumDR() {
        int[] target = {2,3,7,8,10};
        assertTrue(new SubsetSumProblem().isSumPossible(target,11));
        assertTrue(new SubsetSumProblem().isSumPossible(target,10));
        assertTrue(new SubsetSumProblem().isSumPossible(target,5));
        assertFalse(new SubsetSumProblem().isSumPossible(target,35));
        assertTrue(new SubsetSumProblem().isSumPossible(target,12));
    }
}
