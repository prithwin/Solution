package com.personal.dynamicprogramming;

import org.testng.annotations.*;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/30/17.
 */
public class CoinChangingProblemTest {
    @Test public void testConChange1() {
        System.out.println("1, 5 , 6 , 8");
        System.out.println("1->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 1));
        System.out.println("2->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 2));
        System.out.println("3->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 3));
        System.out.println("4->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 4));
        System.out.println("5->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 5));
        System.out.println("6->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 6));
        System.out.println("7->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 7));
        System.out.println("8->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 8));
        System.out.println("9->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 9));
        System.out.println("10->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 10));
        System.out.println("11->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 11));
        System.out.println("12->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 12));
        System.out.println("13->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 13));
        System.out.println("15->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 15));
        System.out.println("15->"+new CoinChangingProblem().getNumberOfCoins(Arrays.asList(1,5,6,8), 3000));
    }

    @Test public void testConChange2() {
        System.out.println("1, 5 , 6 , 8");
        System.out.println("1->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 1));
        System.out.println("2->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 2));
        System.out.println("3->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 3));
        System.out.println("4->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 4));
        System.out.println("5->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 5));
        System.out.println("6->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 6));
        System.out.println("7->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 7));
        System.out.println("8->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 8));
        System.out.println("9->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 9));
        System.out.println("10->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 10));
        System.out.println("11->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 11));
        System.out.println("12->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 12));
        System.out.println("13->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 13));
        System.out.println("15->"+new CoinChangingProblem().getNumberOfCoinsOS(Arrays.asList(1,5,6,8), 15));
    }
}
