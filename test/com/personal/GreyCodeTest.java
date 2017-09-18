package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/17/17.
 */
public class GreyCodeTest {
    @Test
    public void testGrayCode() throws Exception {
        System.out.println(new GreyCode().grayCode(2));
    }

}