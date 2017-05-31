package com.personal.dynamicprogramming;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/30/17.
 */
public class CoinCollectingRobotTest {
    @Test public void testCoinCollectingRobot() {
        int[][] board =    {{0, 0, 0, 0, 1, 0},
                            {0, 1, 0, 1, 0, 0},
                            {0, 0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 0, 1},
                            {1, 0, 0, 0, 1, 0}

        };
        System.out.println(new CoinCollectingRobot().getHighestNumber(board));
    }
}
