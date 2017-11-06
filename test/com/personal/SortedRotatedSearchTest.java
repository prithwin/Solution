package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 10/29/17.
 */
public class SortedRotatedSearchTest {
    @Test
    public void testSearch() throws Exception {
        System.out.println(new SortedRotatedSearch().search(new int[] {4,5, 6, 7, 0, 1, 2} , 4));
        System.out.println(new SortedRotatedSearch().search(new int[] {4,5, 6, 7, 0, 1, 2} , 5));
        System.out.println(new SortedRotatedSearch().search(new int[] {4,5, 6, 7, 0, 1, 2} , 6));
        System.out.println(new SortedRotatedSearch().search(new int[] {4,5, 6, 7, 0, 1, 2} , 7));
        System.out.println(new SortedRotatedSearch().search(new int[] {4,5, 6, 7, 0, 1, 2} , 0));
        System.out.println(new SortedRotatedSearch().search(new int[] {4,5, 6, 7, 0, 1, 2} , 1));
        System.out.println(new SortedRotatedSearch().search(new int[] {4,5, 6, 7, 0, 1, 2} , 2));
        System.out.println(new SortedRotatedSearch().search(new int[] {3,1,2} , 3));
        System.out.println(new SortedRotatedSearch().search(new int[] {3,1,2} , 1));
        System.out.println(new SortedRotatedSearch().search(new int[] {3,1,2} , 2));
    }

}