//package com.personal;
//
//import com.personal.util.ListNode;
//import com.personal.util.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * Created by prajeeva on 10/31/17.
// */
//public class ReOrderLinkedList {
//    public void reorderList(ListNode head) {
//        ListNode m = head;
//        ListNode f = head.next;
//        while(f!=null && f.next!=null) {
//            m = m.next;
//            f = f.next.next;
//        }
//        m = m.next;
//        System.out.println(m);
//    }
//
//    private void
//
//    public static void main(String[] args) {
//        //this is how you do it man
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        new ReOrderLinkedList().reorderList(head);
//    }
//
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> response = new ArrayList<>();
//        Stack<TreeNode> s = new Stack<>();
//        s.push(root);
//        m(root , s , response);
//        return response;
//    }
//
//    private void m(TreeNode node , Stack<TreeNode> s , List<String> response) {
//        if(node.left == null && node.right == null) {
//            response.add(s.stream().map(t -> t.number.number+"").reduce((a,b) -> a+"->"+b).get());
//            return;
//        } else {
//            if(node.left != null) {
//                s.push(node.left);
//                m(node.left , s , response);
//                s.pop();
//            }
//            if(node.right != null) {
//                s.push(node.right);
//                m(node.right , s , response);
//                s.pop();
//            }
//        }
//    }
//}
