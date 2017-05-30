package com.personal.dynamicprogramming;

import org.testng.annotations.*;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/30/17.
 */
public class CoinChangingProblemTest {
    @Test public void testConChangingUnbounded() {
        assertEquals(2,new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1, 5, 6, 8),14));
        assertEquals(2,new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1, 5, 6, 8),14));
    }
}
