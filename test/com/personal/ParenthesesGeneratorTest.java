package com.personal;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.*;

/**
 * Created by pr250155 on 5/15/17.
 */
public class ParenthesesGeneratorTest {
    @Test public void testParenthesesGenerator() {
         List<String> result = new ParenthesisGenerator().generate(3);
         result.stream().forEach(System.out::println);
    }
}
