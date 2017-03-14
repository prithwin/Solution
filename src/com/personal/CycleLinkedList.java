package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;

/**
 * Created by prajeev on 14/3/17.
 */
public class CycleLinkedList {
    public static void main(String[] args) {
        int[] fromArray = {1,2,3,4,5,6};
        LinkedList toRotate = new LinkedList(fromArray);
        toRotate.rotate();
        System.out.println("watch");
    }
}
