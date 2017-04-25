package com.personal.util;

/**
 * Created by pr250155 on 4/20/17.
 */
public class AVLTree extends BinarySearchTree {
    AVLTreeNode root;


    public void add(AVLTreeNode node){
        if(root == null){
            node.nodeHeight = 0;
            this.root = node;
        } else {
            addInternal(root, node);
        }
    }

    private void addInternal(AVLTreeNode where, AVLTreeNode what) {
        if( where == null ){
            return;
        } else {
            if(where.left == null && what.number.compareTo(where.number) <= 0) {
                what.nodeHeight = 0;
                where.left = what;
            } else if(where.right == null && what.number.compareTo(where.number) == 1){
                what.nodeHeight = 0 ;
                where.right = what;
            } else if(what.number.compareTo(where.number) <= 0) {
                addInternal(where.left,what);
            } else {
                addInternal(where.right,what);
            }
            where.nodeHeight = 1 +  Mathematical.maximum(getNodeHeight(where.left),getNodeHeight(where.right));
            int balance = getNodeHeight(where.left) -  getNodeHeight(where.right);
        }
    }

    public void addUnbalanced(AVLTreeNode node) {
       if(root == null){
           node.nodeHeight = 0;
           this.root = node;
       } else {
           if ( this.root.number.compareTo(node.number) == 1 ) {
              avlAddInternalUnbalanced(root,node);
           } else {
              avlAddInternalUnbalanced(root,node);
           }
       }

   }

   public void avlAddInternalUnbalanced(AVLTreeNode where, AVLTreeNode what) {
       if( where == null ){
           return;
       } else {
           if(where.left == null && what.number.compareTo(where.number) <= 0) {
               what.nodeHeight = 0;
               where.left = what;
           } else if(where.right == null && what.number.compareTo(where.number) == 1){
               what.nodeHeight = 0 ;
               where.right = what;
           } else if(what.number.compareTo(where.number) <= 0) {
               avlAddInternalUnbalanced(where.left,what);
           } else {
               avlAddInternalUnbalanced(where.right,what);
           }
           where.nodeHeight = 1 +  Mathematical.maximum(getNodeHeight(where.left),getNodeHeight(where.right));
       }
   }

    private int getNodeHeight(AVLTreeNode node) {
        if(node == null){
            return -1;

        } else{
            return node.nodeHeight;
        }
    }

    public void printAVLTree(){
        printAvlTreeInOrder(root);
    }

    private void printAvlTreeInOrder(AVLTreeNode node) {
        if(node == null)
            return;
        printAvlTreeInOrder(node.left);
        System.out.println(node.number+"->"+node.nodeHeight);
        printAvlTreeInOrder(node.right);
    }
}
