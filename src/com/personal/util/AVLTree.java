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

            if( balance > 1) {
                System.out.println("at "+ where.number + " the left tree is larger than the right tree");
                where = rotateRight(where);
                System.out.println("examine");
            }
        }
    }

    private AVLTreeNode rotateRight(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.nodeHeight = Mathematical.maximum(getNodeHeight(y.left), getNodeHeight(y.right)) + 1;
        x.nodeHeight = Mathematical.maximum(getNodeHeight(x.left), getNodeHeight(x.right)) + 1;

        // Return new root
        return x;
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
