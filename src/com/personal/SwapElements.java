package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;

/**
 * Created by prajeev on 9/8/16.
 */
public class SwapElements {
    public void swapElement(int left, int right,int[] asList){
        LinkedList targetList = new LinkedList(asList);
        ListNode current = targetList.getHead();
        int currentPointer = 1;
        ListNode leftPrevNode=null,leftNode=null,leftNextNode=null,
                rightPrevNode=null,rightNode=null,rightNextNode=null;
        while (current!=null){

            if(currentPointer+1 == left){
                leftPrevNode = current;
                leftNode = current.next;
                leftNextNode = current.next.next;
            }
            if(currentPointer+1 == right){
                rightPrevNode = current;
                rightNode = current.next;
                rightNextNode = current.next.next;
            }
            currentPointer++;
            current = current.next;
        }
        //do the exchange
        if(left==1){
            rightPrevNode.next = leftNode;
            leftNode.next = rightNextNode;
        }
//        rightPrevNode.next = leftNode;
//        leftNode.next = rightNextNode;
//        leftPrevNode.next = rightNode;
//        rightNode.next = leftNextNode;
        System.out.println("real sociadad");

    }

    public static void main(String[] args){
        int[] asList = {1,2,3,4,5,6,7,8,9,10}; //1,9,3,4,5,6,7,8,2,10
        new SwapElements().swapElement(1,3,asList);
    }
}
