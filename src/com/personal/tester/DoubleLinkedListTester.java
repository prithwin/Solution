package com.personal.tester;

import com.personal.util.DoublyLinkedList;

/**
 * Created by pr250155 on 4/1/17.
 */
public class DoubleLinkedListTester {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        int[] integers = {1,2,3,4,5};
        linkedList.add(integers);
        System.out.println(linkedList);
        linkedList.reverse();
        System.out.println(linkedList);
    }
}
