package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/8/17.
 */
public class DecimalToBaseNTest {
    @Test public void testBinaryConversion(){
        System.out.println(new DecimalToBaseN().decimalToBaseN(13,2));
        System.out.println(new DecimalToBaseN().baseNToDecimal(new DecimalToBaseN().decimalToBaseN(13, 2),2));

    }

    @Test public void testOctalConversion(){
        System.out.println(new DecimalToBaseN().decimalToBaseN(13,8));
        System.out.println(new DecimalToBaseN().baseNToDecimal(new DecimalToBaseN().decimalToBaseN(13, 8),8));
    }

    @Test public void testHexadecimaConversion(){
        System.out.println(new DecimalToBaseN().decimalToBaseN(555,16));
        System.out.println(new DecimalToBaseN().baseNToDecimal(new DecimalToBaseN().decimalToBaseN(555, 16),16));
    }

    @Test public void testHardWare() {
        System.out.println(Integer.toHexString(-1));
    }

}
