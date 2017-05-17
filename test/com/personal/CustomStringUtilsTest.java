package com.personal;

import com.personal.util.CustomStringUtils;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by pr250155 on 5/17/17.
 */
public class CustomStringUtilsTest {
    @Test public void testString() {
        System.out.println(new CustomStringUtils().reverse2("ALPHABETS"));
    }
}
