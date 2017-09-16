package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/13/17.
 */
public class PhoneDigitsTest {
    @Test
    public void testGetCombinations() throws Exception {
        System.out.println(new PhoneDigits().getCombinations("23"));
    }

}