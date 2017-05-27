package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/26/17.
 */
public class ValidateParenthesesTest {

    @Test public void testValidParentheses() {
        assertTrue(new ValidateParentheses().isValid("(1+2)"));
    }

    @Test public void testValidParentheses2() {
        assertTrue(new ValidateParentheses().isValid("{(1+2)*(3+4)}"));
    }

    @Test public void testValidParentheses3() {
        assertFalse(new ValidateParentheses().isValid("{((1+2)*(3+4)}"));
    }
}
