package com.personal.util;

import java.util.*;

/**
 * Created by prajeev on 19/3/17.
 */
public class BinaryTree {
    public TreeNode root;

    public void printPreOrder() {
        printPreOrderInternal(this.root);
    }

    private void printPreOrderInternal(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.number);
        printPreOrderInternal(root.left);
        printPreOrderInternal(root.right);
    }

    public void printinOrder() {
        printinOrderInternal(this.root);
    }

    private void printinOrderInternal(TreeNode root){
        if(root == null)
            return;
        printinOrderInternal(root.left);
        System.out.println(root.number);
        printinOrderInternal(root.right);
    }



    public void printPostOrder() {
        printPostOrderInternal(root);
    }

    private void printPostOrderInternal(TreeNode root){
        if(root == null)
            return;
        printPostOrderInternal(root.left);
        printPostOrderInternal(root.right);
        System.out.println(root.number);
    }

    public void printLevelOrder(){
        Queue<TreeNode> printQueue = new java.util.LinkedList<>();
        printQueue.add(this.root);
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

    public BinaryTree(int root) {
        TreeNode treeNode = new TreeNode(root);
        this.root = treeNode;
        this.root.left = null;
        this.root.right = null;
    }

    public BinaryTree() {
        super();
    }

    public int height(){
        return computeHeight(root);
    }

    public int computeHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int lHeight = computeHeight(node.left);
        int rHeight = computeHeight(node.right);
        if (lHeight > rHeight){
            return 1+lHeight;
        } else {
            return 1+rHeight;
        }
    }

    public int size(){
        return computeSize(this.root);
    }

    private int computeSize(TreeNode node) {
        if(node==null){
            return 0;
        }
        return 1+ computeSize(node.left)+ computeSize(node.right);

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BinaryTree){
            BinaryTree that = (BinaryTree) obj;
            if(btreeEquals(this.root,that.root)){
                return true;
            }
        }
        return  false;
    }

    private boolean btreeEquals(TreeNode lhs, TreeNode rhs) {
        if(lhs == null || rhs == null){
            return true;
        }
        return (lhs.number.equals(rhs.number)) && btreeEquals(lhs.left,rhs.left) && btreeEquals(lhs.right,rhs.right);
    }

    public void mirror(){
        realMirror(this.root);
    }

    private void realMirror(TreeNode node) {
        if(node==null){
            return;
        }
        realMirror(node.left);
        realMirror(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void printAllPaths(){
        Stack<TreeNode> treeStack = new Stack<>();
        printAllPaths(this.root,treeStack);
    }


    private void printAllPaths(TreeNode node, Stack<TreeNode> treeStack) {
        if(node==null){
            return;
        }
        treeStack.push(node);
        if(node.left == null && node.right == null){
            System.out.println(treeStack);
        }else {
            printAllPaths(node.left, treeStack);
            treeStack.pop();
            printAllPaths(node.right, treeStack);
            treeStack.pop();
        }
    }

    public int countLeaves(){
        return countLeavesInternal(this.root);
    }

    private int countLeavesInternal(TreeNode node) {
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return 1;
        }
        return countLeavesInternal(node.left)+countLeavesInternal(node.right);
    }

    public void printSpiralOrder(){
        Stack<TreeNode> printStack = new Stack<>();
        printStack.add(root);
        printSpiralOrderInternal(printStack,false);
    }

    private void printSpiralOrderInternal(Stack<TreeNode> printStack,boolean flip) {
        if(printStack.isEmpty()){
            return;
        }
        Stack tempStack = new Stack();
        while (!printStack.empty()){
            TreeNode examination = printStack.pop();
            System.out.println(examination.number);
            if(!flip) {
                if (examination.left != null)
                    tempStack.push(examination.left);
                if (examination.right != null)
                    tempStack.push(examination.right);
            } else {
                if (examination.right != null)
                    tempStack.push(examination.right);
                if (examination.left != null) {
                    tempStack.push(examination.left);
                }
            }
        }

        printSpiralOrderInternal(tempStack,!flip);
    }

    public boolean isTreeBST(){
        return isTreeBSTInteral(root);
    }

    private boolean isTreeBSTInteral(TreeNode node) {
        if(node == null || (node.left==null && node.right==null)){
            //its balanced till this point.
            return true;
        }

        if(node.right==null || !(node.left.number.compareTo(node.number) <= 0)){
            return false;
        }
        if(node.left==null || !(node.right.number.compareTo(node.number)==1)){
            return false;
        }
        if(!(node.left.number.compareTo(node.number) <= 0 &&  node.right.number.compareTo(node.number)==1)){
            return false;
        }
        return isTreeBSTInteral(node.left) && isTreeBSTInteral(node.right);
    }

    /**
     * amazon interview question: in a binary tree replace all the nodes with the sum of its children:
     * algorithm:
     * -if you have reached the bottom of the tree add copy the left leaf or right leaf if the other one
     * is empty.
     * otherwise replace this with the sum of both of its children
     *
     */
    public void summer(){
        summerInternal(root);
    }


    private void summerInternal(TreeNode node) {
        if(node.left == null && node.right==null){
            return;
        }
        if(node.left == null & node.right!=null){
            node.number.number = node.right.number.number;
            return;
        }
        if(node.left != null & node.right==null){
            node.number.number = node.left.number.number;
            return;
        } else {
            node.number.number = node.left.number.number + node.right.number.number;
        }
        if(node.left!=null)
            summerInternal(node.left);
        if(node.right!=null)
            summerInternal(node.right);
        return;

    }
}
