package com.personal;

import com.personal.util.BinaryTree;
import com.personal.util.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prajeev on 19/3/17.
 */
public class TreeTraversals {
    BinaryTree tree;

    public void printPreOrder(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.number);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printinOrder(TreeNode root){
        if(root == null)
            return;
        printPreOrder(root.left);
        System.out.println(root.number);
        printPreOrder(root.right);
    }

    public void printPostOrder(TreeNode root){
        if(root == null)
            return;
        printPreOrder(root.left);
        printPreOrder(root.right);
        System.out.println(root.number);
    }

    public void printLevelOrder(){
        Queue<TreeNode> printQueue = new LinkedList<>();
        printQueue.add(this.tree.root);
        printLevelOrderInternal(printQueue);
    }

    private void printLevelOrderInternal(Queue<TreeNode> printQueue) {
        if(printQueue.isEmpty()){
            return;
        }
        TreeNode examination = printQueue.remove();
        System.out.println(examination.number);
        if(examination.left!=null)
            printQueue.add(examination.left);
        if(examination.right!=null)
            printQueue.add(examination.right);
        printLevelOrderInternal(printQueue);

    }


    public static void main(String[] args) {
        TreeTraversals treeTraversals = new TreeTraversals();
        treeTraversals.tree = new BinaryTree(1);
        treeTraversals.tree.root.left = new TreeNode(2);
        treeTraversals.tree.root.right = new TreeNode(3);
        treeTraversals.tree.root.left.left = new TreeNode(4);
        treeTraversals.tree.root.left.right = new TreeNode(5);
        treeTraversals.tree.root.right.left = new TreeNode(6);
        treeTraversals.tree.root.right.left.left = new TreeNode(8);
        treeTraversals.tree.root.right.left.right = new TreeNode(9);
        treeTraversals.tree.root.right.right = new TreeNode(7);

        System.out.println("printing in order");
        treeTraversals.printinOrder(treeTraversals.tree.root);
        System.out.println("printing pre order");
        treeTraversals.printPreOrder(treeTraversals.tree.root);
        System.out.println("printing post order");
        treeTraversals.printPostOrder(treeTraversals.tree.root);

        System.out.println("the height of this tree is:" + treeTraversals.tree.height());
        System.out.println("the size of this tree is:" + treeTraversals.tree.size());
        System.out.println("printing the Tree in level order");
        treeTraversals.printLevelOrder();
        TreeTraversals treeTraversals2 = new TreeTraversals();
        treeTraversals2.tree = new BinaryTree(1);
        treeTraversals2.tree.root.left = new TreeNode(2);
        treeTraversals2.tree.root.right = new TreeNode(3);
        treeTraversals2.tree.root.left.left = new TreeNode(4);
        treeTraversals2.tree.root.left.right = new TreeNode(5);
        treeTraversals2.tree.root.right.left = new TreeNode(6);
        treeTraversals2.tree.root.right.left.left = new TreeNode(8);
        treeTraversals2.tree.root.right.left.right = new TreeNode(9);
        treeTraversals2.tree.root.right.right = new TreeNode(7);

        System.out.println("checking equality with itsself: "+ treeTraversals.tree.equals(treeTraversals2.tree));

    }
}
