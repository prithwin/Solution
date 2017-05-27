package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;


/**
 * Created by pr250155 on 5/27/17.
 */
public class TowersOfHanoiTest {
    @Test public void testTowersMoves8(){
        assertEquals(new TowersOfHanoi().numberOfMoves(8),255);
    }

    @Test public void printMoves() {
        new TowersOfHanoi().printMoves(8);
    }
}
