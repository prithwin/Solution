package com.personal.util;

/**
 * Created by prajeev on 9/8/16.
 */
public class LinkedList {
    ListNode head;

    public LinkedList(int[] fromList){
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

    public ListNode getHead(){
        return  head;
    }
}
