package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class PalindromicPossiblitiesTest {
    @Test public void printPossibilities() {
        new PallindromicPossibilities().printPallindromicPossiblities("PritMalayalaMhwin");

    }

    @Test public void printPossibilities2() {
        new PallindromicPossibilities().printPallindromicPossiblities("nitin");

    }
}
