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
        assertEquals(2,new CoinChangingConstrained().getNumberOfCoins(Arrays.asList(1, 5, 6, 8), 14));
    }

    @Test public void testConChangeConstrainedOS() {
        System.out.println("1, 5 , 6 , 8");
        System.out.println("1->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 1));
        System.out.println("2->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 2));
        System.out.println("3->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 3));
        System.out.println("4->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 4));
        System.out.println("5->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 5));
        System.out.println("6->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 6));
        System.out.println("7->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 7));
        System.out.println("8->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 8));
        System.out.println("9->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 9));
        System.out.println("10->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 10));
        System.out.println("11->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 11));
        System.out.println("12->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 12));
        System.out.println("13->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 13));
        System.out.println("15->"+new CoinChangingConstrained().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 15));
    }
}
