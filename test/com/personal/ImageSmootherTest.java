package com.personal;

import com.personal.util.MatrixUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/13/17.
 */
public class ImageSmootherTest {
    @Test
    public void testImageSmoother() throws Exception {
//        int[][] image = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        int[][] image = {{1}};
        MatrixUtil.print2dMatrix(new ImageSmoother().imageSmoother(image));
    }

}