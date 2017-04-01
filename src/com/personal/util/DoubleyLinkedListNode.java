package com.personal.util;

/**
 * Created by pr250155 on 4/1/17.
 */
public class DoubleyLinkedListNode {
    ComparableNumber number;
    DoubleyLinkedListNode prev;
    DoubleyLinkedListNode next;


    public DoubleyLinkedListNode(int x) {
        this.number = new ComparableNumber(x);
    }

    @Override
    public String toString() {
       return number+"";
    }
}
