package com.personal;

import com.personal.util.MatrixUtil;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/1/17.
 */
public class MatrixUtilTester {
    @Test public void testSpiralPrinter() {
        int[][] target = {{1,2,3,4},
                          {1,2,3,4},
                          {1,2,3,4},
                          {1,2,3,4}};
        MatrixUtil.spiralPrint(target);
    }

    @Test public void testPrinter() {
        MatrixUtil.printTreeNumber(true);
    }

    @Test public void testPrinterN() {
        MatrixUtil.printTreeNumber(false);
    }
}
