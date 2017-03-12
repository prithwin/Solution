package com.personal;

import com.personal.util.LinkedList;
import com.personal.util.ListNode;

import java.util.Stack;

/**
 * Created by prajeev on 8/3/17.
 */
public class LinkedListPallindrome {
    LinkedList linkedList;

    public LinkedListPallindrome() {
        int[] initList = {1, 2, 3, 4, 5,6};
        this.linkedList = new LinkedList(initList);
    }

    public static void main(String[] args) {
        LinkedListPallindrome pal = new LinkedListPallindrome();
        System.out.println(pal.checkPallindrome());
        System.out.println(pal.checkPallindromeRecursively());

    }

    private boolean checkPallindromeRecursively(){
        Stack<ListNode> inorderstack = new Stack<ListNode>();
        Stack<ListNode> revesseorderstack = new Stack<ListNode>();
        createStack(inorderstack,revesseorderstack,this.linkedList.getHead());
        System.out.println("check stacks");
        return false;
    }

    private void createStack(Stack<ListNode> inorderstack, Stack<ListNode> revesseorderstack, ListNode node) {
        if (node==null) {
            return;
        }
        inorderstack.push(node);
        createStack(inorderstack,revesseorderstack,node.next);
        revesseorderstack.push(node);
    }

    private boolean checkPallindrome() {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = linkedList.getHead();
        int factor = 0;
        boolean axisPassed = false;
        if (linkedList.size() % 2 == 0) {
            factor = linkedList.size();
            axisPassed = true;
        } else {
            factor = linkedList.size() + 1;
        }
        for (int i = 0; i <= linkedList.size(); i++) {
            if (i < factor / 2) {
                stack.push(curr);
            } else {
                if (!stack.isEmpty()) {
                    ListNode check = stack.pop();
                    if (axisPassed) {
                        if (!check.equals(curr)) {
                            return false;
                        }
                    } else {
                        axisPassed = true;
                        continue;
                    }
                } else {
                    break;
                }

            }
            curr = curr.next;
        }
        return true;
    }

}
