package com.design.patterns.iterator;

import com.personal.util.ListNode;

import java.util.Iterator;

/**
 * Created by prajeev on 9/8/16.
 */
public class IterableLinkedList {
    public ListNode head;

    public IterableLinkedList(int[] fromList){
       for(int item : fromList){
           add(item);
       }
    }

    public void add(int item) {
        if(head==null){
            head = new ListNode(item);
            return;
        }
        ListNode target = head;
        while(target.next!=null)
            target = target.next;
        //at this moment traget is pointing at the last node
        target.next = new ListNode(item);
    }

    public MyIterator iterator(){
        return new LinkedListIterator(this);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        IterableLinkedList list = new IterableLinkedList(array);
        MyIterator<ListNode> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().val);
        }
    }
}


