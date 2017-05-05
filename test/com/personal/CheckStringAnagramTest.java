package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/5/17.
 */
public class CheckStringAnagramTest {

    @Test
    public void checkAnagram () {
        assertTrue(new CheckStringAnagram().isAnagram("ABCD","ABDC"));
    }

    @Test
    public void testNonagram() {
        assertFalse(new CheckStringAnagram().isAnagram("ABCD","ABBCD"));
    }
}
