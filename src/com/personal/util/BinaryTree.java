package com.personal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by prajeev on 19/3/17.
 */
public class BinaryTree {
    public TreeNode root;

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
        printAllPaths(this.root,treeStack,1);
    }

    private void printAllPaths(TreeNode node, Stack<TreeNode> treeStack, int pathLenght) {
        if(node==null){
            return;
        }
        treeStack.push(node);
        if(node.left == null && node.right == null){
            System.out.println(treeStack);
        }else {
            printAllPaths(node.left, treeStack, pathLenght+1);
            treeStack.pop();
            printAllPaths(node.right, treeStack, pathLenght+1);
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


}
