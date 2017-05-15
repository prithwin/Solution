package com.personal;

import org.testng.annotations.Test;
import static org.junit.Assert.*;

/**
 * Created by pr250155 on 5/15/17.
 */
public class MostFrequentCharacterTest {
    @Test public void testGetMostFrequentChars() {
        MostFrequentCharacter.Answer answer = new MostFrequentCharacter().findMostFrequentChar("AAAAAAAAAAAAAAAAAAbcdf" +
                "eghIIIj");
        assertEquals(answer.item,'A');
        assertEquals(answer.multiplicity,18);
    }
}
