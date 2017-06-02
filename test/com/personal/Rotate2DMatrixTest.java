package com.personal;

import java.util.*;
import static org.testng.Assert.*;

import com.personal.util.MatrixUtil;
import org.testng.annotations.*;

/**
 * Created by prith on 02-06-2017.
 */
public class Rotate2DMatrixTest {
    @Test public void testMatrixRotation() {
        int[][] originals =    {{1, 2, 3, 4, 5},                             //1
                                {6, 7, 8, 9, 10},                            //2
                                {11,12,13,14,15},                            //3
                                {16,17,18,19,20},                            //4
                                {21,22,23,24,25}};
        int[][] matrix =   {{1, 2, 3, 4, 5},                             //1
                            {6, 7, 8, 9, 10},                            //2
                            {11,12,13,14,15},                            //3
                            {16,17,18,19,20},                            //4
                            {21,22,23,24,25}};                           //5
        MatrixUtil.print2dMatrix(matrix);
        new Rotate2DMatrix().inPlaceRotate(matrix);
        System.out.println();
        MatrixUtil.print2dMatrix(matrix);
        new Rotate2DMatrix().inPlaceRotate(matrix);
        System.out.println();
        MatrixUtil.print2dMatrix(matrix);
        new Rotate2DMatrix().inPlaceRotate(matrix);
        System.out.println();
        MatrixUtil.print2dMatrix(matrix);
        new Rotate2DMatrix().inPlaceRotate(matrix);
        System.out.println();
        MatrixUtil.print2dMatrix(matrix);
        assertTrue(MatrixUtil.isEqual(originals,matrix));
    }
}
