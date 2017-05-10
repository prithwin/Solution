package com.personal;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;
/**
 * Created by pr250155 on 5/9/17.
 *
 */
public class KClosestElementsTest {
    @Test public void getClosest4Elements(){
        new KClosestElements().findKClosestElements(Arrays.asList(12, 16, 22, 30, 34, 39, 42
                , 45, 48, 50, 53, 55, 56) , 4 , 900).stream().forEach(a -> System.out.print(a+","));
        System.out.println();
        new KClosestElements().findKClosestElements(Arrays.asList(12, 16, 22, 30, 34, 39, 42
                , 45, 48, 50, 53, 55, 56) , 4 , 35).stream().forEach(a -> System.out.print(a+","));
        System.out.println();
        new KClosestElements().findKClosestElements(Arrays.asList(12, 16, 22, 30, 34, 39, 42
                , 45, 48, 50, 53, 55, 56) , 4 , 0).stream().forEach(a -> System.out.print(a+","));

    }
}
