package com.design.patterns.iterator;

import com.personal.util.ListNode;

/**
 * Created by pr250155 on 3/31/17.
 */
public class LinkedListIterator implements MyIterator {

    IterableLinkedList backinglist;

    ListNode current;

    LinkedListIterator(IterableLinkedList list){
        this.backinglist = list;
        current = list.head;
    }

    @Override
    public boolean hasNext() {
        if(current==null){
            return false;
        }
        return true;
    }

    @Override
    public ListNode next() {
        ListNode returnVal = current;
        current = current.next;
        return returnVal;
    }
}
