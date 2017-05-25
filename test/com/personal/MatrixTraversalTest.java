package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/15/17.
 */
public class MatrixTraversalTest {
    @Test public void testMatrixTravels() {
        int[][] matrix = {{1,1},{1,1}};
        assertEquals(2,new MatrixTraversal().getNumberOfPaths(matrix,0,0));
        int matrix2[][] = {{1,1,1},{1,1,1},{1,1,1}};
        assertEquals(6,new MatrixTraversal().getNumberOfPaths(matrix2,0,0));
    }
}
