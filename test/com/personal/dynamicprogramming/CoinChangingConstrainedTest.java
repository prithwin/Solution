package com.personal.dynamicprogramming;

import org.testng.annotations.*;

import java.util.Arrays;

import static org.testng.Assert.*;


/**
 * Created by pr250155 on 5/29/17.
 */
public class CoinChangingConstrainedTest {

    @Test public void testConChangeConstrained() {
        assertEquals(2,new CoinChangingConstrained().getNumberOfCoins(Arrays.asList(1, 5, 6, 8),11));
        assertEquals(2, new CoinChangingConstrained().getNumberOfCoins(Arrays.asList(1, 5, 6, 8), 14));
    }

    @Test public void testConChangeConstrainedOS() {
        assertEquals(2,new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1, 5, 6, 8), 11));
        assertEquals(2,new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1, 5, 6, 8), 14));
    }
}
