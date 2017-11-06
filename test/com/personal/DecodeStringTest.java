package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 11/1/17.
 */
public class DecodeStringTest {
    @Test
    public void testDecodeString() throws Exception {
        System.out.println(new DecodeString().decodeString("100[codefights]"));
    }

}