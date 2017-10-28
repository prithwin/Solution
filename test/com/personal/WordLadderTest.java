package com.personal;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 9/30/17.
 */
public class WordLadderTest {
    @Test
    public void testLadderLength() throws Exception {
        Set<String> req = new HashSet<>();
        System.out.println(new WordLadder().ladderLength("hit" , "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

}