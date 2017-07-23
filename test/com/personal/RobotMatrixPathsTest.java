package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/16/17.
 */
public class RobotMatrixPathsTest {
    @Test
    public void testUniquePaths() throws Exception {
        System.out.println(new RobotMatrixPaths().uniquePaths(1,10));
    }

}