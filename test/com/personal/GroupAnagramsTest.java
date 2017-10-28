package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 10/21/17.
 */
public class GroupAnagramsTest {
    @Test
    public void testGroupAnagrams() throws Exception {
        String[] q = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(q));
    }

}