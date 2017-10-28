package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 10/22/17.
 */
public class IsomorphicStringsTest {
    @Test
    public void testIsIsomorphic() throws Exception {
        System.out.println(new IsomorphicStrings().isIsomorphic("foo" , "bar"));
    }

}