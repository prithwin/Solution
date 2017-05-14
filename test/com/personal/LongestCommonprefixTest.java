package com.personal;

import org.testng.annotations.*;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/12/17.
 */
public class LongestCommonprefixTest {
    @Test public void testLCP() {
        assertEquals("Es",new LongestCommonPrefix().getLongestCommonPrefix(Arrays.asList("Essaysdfsdf", "Esspy","Espisjdfjjef")));
        assertEquals("Ess",new LongestCommonPrefix().getLongestCommonPrefix(Arrays.asList("Essaysdfsdf", "Esspy")));
        assertEquals("Ess",new LongestCommonPrefix().getLongestCommonPrefix(Arrays.asList("Ess", "Ess")));
        assertEquals("https://google.com/",new LongestCommonPrefix().getLongestCommonPrefix(Arrays.asList("https://google.com/sdjfji/sdfji", "https://google.com/jiefjis/jiefj/","https://google.com/jiefjisjie/jsiefj")));

    }
}
