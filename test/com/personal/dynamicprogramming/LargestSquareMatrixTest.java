package com.personal.dynamicprogramming;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class LargestSquareMatrixTest {
    @Test public void testLargestCompleteMatrix() {
        int[][] matrix = {  {0,1,1,0,1,0,0},
                            {0,1,0,1,0,1,0},
                            {0,1,1,1,1,0,0},
                            {0,1,1,1,0,1,0},
                            {0,1,1,1,1,0,0},
                            {0,0,0,0,0,0,0}
        };
        new LargestSquareCompleteMatrix().findLargetCompleteMatrix(matrix);
    }
}
