package com.personal;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/25/17.
 */
public class StringTokenizerTest {
    @Test public void testTokenizer() {
        System.out.println(new StringTokenizer().tokenizeString("This is a boody nightmare",' '));
    }

    @Test public void testTokenizer2() {
        System.out.println(new StringTokenizer().tokenizeString("This,is,a,boody,nightmare",','));
    }
}
