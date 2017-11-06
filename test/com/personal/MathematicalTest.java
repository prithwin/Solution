package com.personal;

import com.personal.util.Mathematical;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/6/17.
 */
public class MathematicalTest {
    @Test
    public void testFactorial() {
        assertEquals(Mathematical.factorial(1),1);
        assertEquals(Mathematical.factorial(2),2);
        assertEquals(Mathematical.factorial(3),6);
        assertEquals(Mathematical.factorial(4),24);
    }

    @Test public void testPow(){
        System.out.println(Mathematical.power(2,20));
    }

    @Test public void TestSineWave() {
        for(int i = 0 ; i < 100 ; i++) {
            System.out.println(Math.sin(i));
        }
    }

    @Test public void testComplement() {
        System.out.println(new Mathematical().findComplement(7));
    }

}
