package com.personal;

import org.testng.annotations.Test;
import com.personal.util.LinkedList;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/31/17.
 */
public class DeletedDuplicateInListTest {
    @Test
    public void testDeleteDuplicates() throws Exception {
        int[] array = {1,1,1,1,2,3,4,4,4,5,6,7,8,8};
        LinkedList target = new LinkedList(array);
        System.out.println("The original list is as follows");
        System.out.println(target);
        System.out.println(new DeletedDuplicateInList().deleteDuplicates(target.head));
    }
}