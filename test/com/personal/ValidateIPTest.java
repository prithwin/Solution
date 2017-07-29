package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/29/17.
 */
public class ValidateIPTest {
    @Test
    public void testValidIPAddress() throws Exception {
        System.out.println(new ValidateIP().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

}