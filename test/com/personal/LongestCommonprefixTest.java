package com.personal;

import org.testng.annotations.*;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/12/17.
 */
public class LongestCommonprefixTest {
    @Test public void testLCP() {
        System.out.println(new LongestCommonPrefix().getLongestCommonPrefix(Arrays.asList("Essaysdfsdf", "Esspy","Espisjdfjjef")));
    }
}
