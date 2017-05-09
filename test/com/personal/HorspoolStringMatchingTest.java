package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/9/17.
 */
public class HorspoolStringMatchingTest {
    @Test public void testStringMatching(){
        assertTrue(new HorspoolStringMatching().contains("THIS IS THE TARGET", "ARGE"));
        assertTrue(new HorspoolStringMatching().contains("THIS IS THE TARGET", "THIS IS THE TARGET"));
        assertTrue(new HorspoolStringMatching().contains("THIS IS THE TARGET", "S THE T"));
        assertFalse(new HorspoolStringMatching().contains("THIS IS THE TARGET", "A THE T"));
    }
}
