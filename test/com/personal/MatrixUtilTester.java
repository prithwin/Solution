package com.personal;

import com.personal.util.MatrixUtil;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/1/17.
 */
public class MatrixUtilTester {
    @Test
    public void testConchPrint() throws Exception {
        int[][] target =   {{1,2,3,4,5},
                            {6,7,8,9,10},
                            {11,12,13,14,15}};
        System.out.println(MatrixUtil.conchPrint(target));
    }


    @Test
    public void testConchPrint3() throws Exception {
        int[][] target =   {{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}
            };
        MatrixUtil.print2dMatrix(target);
        System.out.println(MatrixUtil.conchPrint(target));
    }

    @Test
    public void testConchPrint2() throws Exception {
        int[][] target =   {{1,2,3}};
        System.out.println(MatrixUtil.conchPrint(target));
    }


    @Test public void testSpiralPrinter() {
        int[][] target = {{1 ,2 , 3, 4},
                          {1 ,2 , 3, 4},
                          {1 ,2 , 3, 4},
                          {1 ,2 , 3,4} };
        MatrixUtil.spiralPrint(target);
    }

    @Test public void testPrinter() {
        MatrixUtil.printTreeNumber(true);
    }

    @Test public void testPrinterN() {
        MatrixUtil.printTreeNumber(false);
    }
}
