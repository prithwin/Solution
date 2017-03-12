package com.personal.util;

/**
 * Created by prajeev on 9/8/16.
 */
public class LinkedList {
    public ListNode head;
    int length;

     public LinkedList(){
        super();
         length=0;
     }

    public LinkedList(int[] fromList){
        length=0;
       for(int item : fromList){
           add(item);
       }
    }

    public void add(int item) {
        length++;
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

    public int size() {
        return length;

    }
}
