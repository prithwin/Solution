package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;

/**
 * Created by prajeev on 10/3/17.
 */
public class LoopedList {
    public boolean checkForLoops(LinkedList list){
        return detectLoops(list.getHead());
    }

    private boolean detectLoops(ListNode head) {
        ListNode trailingPointer = head;
        ListNode leadPointer = head;
        boolean loopDetected = false;
        while (leadPointer.next!=null && trailingPointer.next!=null){
            trailingPointer = trailingPointer.next;
            leadPointer = leadPointer.next.next;
            if(trailingPointer == leadPointer){
                loopDetected = true;
                break;
            }
        }
        return loopDetected;
    }

    private ListNode findLoopedPoint(ListNode head) {
        ListNode trailingPointer = head;
        ListNode leadPointer = head;
        boolean loopDetected = false;
        while (leadPointer.next!=null && trailingPointer.next!=null){
            trailingPointer = trailingPointer.next;
            leadPointer = leadPointer.next.next;
            if(trailingPointer == leadPointer){
                return trailingPointer;
            }
        }
        return null;
    }

    private ListNode findLoopTermination(ListNode head){
        ListNode loopPoint = findLoopedPoint(head);
        if(loopPoint != null){
            ListNode penultimateLoopPoint = null;
            //there are Loops
            for(int counter = 1; ; counter++){
                penultimateLoopPoint = loopPoint;
                ListNode fromWithinLoop = loopPoint;
                ListNode fromHead = head;
                int currentCounter = counter;
                while(currentCounter>0){
                    currentCounter--;
                    fromHead = fromHead.next;
                    fromWithinLoop = fromWithinLoop.next;
                }
                penultimateLoopPoint = penultimateLoopPoint.next;
                if(fromHead == fromWithinLoop){
                    break;
                }
            }
            return penultimateLoopPoint;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode crossroads = new ListNode(3);
        head.next.next = crossroads;
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = crossroads;
        list.head = head;
        System.out.println(new LoopedList().checkForLoops(list));
        ListNode point = new LoopedList().findLoopTermination(list.head);
        point.next = null;
        System.out.println("wait");
    }
}