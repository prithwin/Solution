package com.personal;

import com.personal.util.ArrayToListConverter;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.List;

/**
 * Created by pr250155 on 5/8/17.
 */
public class DutchNationalFlagTest {
    @Test
    public void testPartition() {
        Integer[] target = {0,0,0,0,1,1,0,1,2,2,1,1,0,1,2,2,0,1,2,0,0,2,1,0,2,1,0,2,2,0,1};
        List<Integer> original = ArrayToListConverter.toArrayList(target);
        new DutchNationalFlag().threeWayPartition(target);
        List<Integer> updated = ArrayToListConverter.toArrayList(target);
        assertEquals(original.stream().reduce((a,b) -> a+b).get(), updated.stream().reduce((a,b) -> a+b).get());
    }

}
