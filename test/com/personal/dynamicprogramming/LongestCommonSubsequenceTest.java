package com.personal.dynamicprogramming;

import com.personal.util.CustomStringUtils;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/22/17.
 */
public class LongestCommonSubsequenceTest {
    @Test public void testMethod() {
        String lcs = new CustomStringUtils().reverse2(new LongestCommonSubsequence().lcs("ABCDGHLQR","AEDPHR"));
        System.out.printf("the longest String is %s and its size is %d",lcs,lcs.length());
        System.out.println(new LongestCommonSubsequence().findLongestCommonSubsequence("ABCDGHLQR","AEDPHR"));
    }
}
