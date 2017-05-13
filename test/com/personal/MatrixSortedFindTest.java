package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/13/17.
 */
public class MatrixSortedFindTest {
    @Test public void testFind() {
        int matrix [][] = { {10, 20, 30, 40,999},
            {15, 25, 35, 45,1000},
            {27, 29, 37, 48,1001},
            {32, 33, 39, 50,1002},
            {320, 330, 390, 500,1003}
        };
        assertTrue(new MatrixSortedFind().findKeyInMatrix(matrix,37));
        assertTrue(new MatrixSortedFind().findKeyInMatrix(matrix,48));
        assertTrue(new MatrixSortedFind().findKeyInMatrix(matrix,40));
        assertTrue(new MatrixSortedFind().findKeyInMatrix(matrix,50));
        assertTrue(new MatrixSortedFind().findKeyInMatrix(matrix,1003));
        assertFalse(new MatrixSortedFind().findKeyInMatrix(matrix,401));
        assertFalse(new MatrixSortedFind().findKeyInMatrix(matrix,51));

    }
}
