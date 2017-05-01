package com.personal.util;

/**
 * Created by pr250155 on 4/20/17.
 */
public class AVLTree extends BinarySearchTree {
    AVLTreeNode root;

    enum BalanceType{
        LL,RR,LR,RL
    }

    public void add(AVLTreeNode node){
        if(root == null){
            node.nodeHeight = 0;
            this.root = node;
        } else {
            root = addInternal(root, node);
        }
    }

    private AVLTreeNode addInternal(AVLTreeNode where, AVLTreeNode what) {
        if(where == null) {
            return null;
        } else {
            if(where.number.compareTo(what.number) == 1) {
                if(where.left == null){
                    where.left = what;
                } else {
                    where.left = addInternal(where.left,what);
                }
            } else {
                if(where.right == null) {
                    where.right = what;
                } else {
                   where.right = addInternal(where.right,what);
                }
            }
            where.nodeHeight = 1 +  Mathematical.maximum(getNodeHeight(where.left),getNodeHeight(where.right));
            int balance = getNodeHeight(where.left) -  getNodeHeight(where.right);

            //LL case
            if (balance > 1 && safeCompare(where,BalanceType.LL)) {
                return rotateRight(where);
            }

            //LR case
            if (balance > 1 && safeCompare(where,BalanceType.LR)) {
                where.left = rotateLeft(where.left);
                return rotateRight(where);
            }

            //RR Case
            if (balance < -1 && safeCompare(where,BalanceType.RR)) {
                return rotateLeft(where);
            }

            //RL CASE
            if (balance < -1 && safeCompare(where,BalanceType.RL)) {
                where.right = rotateRight(where.right);
                return rotateLeft(where);
            }
            return where;
        }
    }

    private boolean safeCompare(AVLTreeNode node, BalanceType balanceType) {
        if(balanceType == BalanceType.LL) {
            if(node.left == null || node.left.left==null){
                return false;
            }
            if(node.left.number.compareTo(node.left.left.number) >= 0){
                return true;
            }
        }
        else if(balanceType == BalanceType.RR) {
            if(node.right == null || node.right.right==null){
                return false;
            }
            if(node.right.number.compareTo(node.right.right.number) == -1){
                return true;
            }
        }

        else if(balanceType == BalanceType.LR) {
            if(node.left == null || node.left.right==null){
                return false;
            }
            if(node.left.number.compareTo(node.left.right.number) == -1){
                return true;
            }
        }
        else if(balanceType == BalanceType.RL) {
            if(node.right == null || node.right.left==null){
                return false;
            }
            if(node.right.number.compareTo(node.right.left.number) >= 0){
                return true;
            }
        }
        return false;
    }


    /**
     *      root                 pivot
     *       /\                  /    \
     *      /  Gamma   ->      alpha   root
     *     pivot                        /  \
     *    /    \                      Beta Gamma
     *   alpha  beta
     */
    private AVLTreeNode rotateRight(AVLTreeNode root) {
        System.out.println("rotating the tree right");
        AVLTreeNode pivot = root.left;
        AVLTreeNode alpha = pivot.left;
        AVLTreeNode beta = pivot.right;
        AVLTreeNode gamma = root.right;

        root.left = beta;
        root.right =  gamma;
        pivot.left = alpha;
        pivot.right = root;

        root.nodeHeight = Mathematical.maximum(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        pivot.nodeHeight = Mathematical.maximum(getNodeHeight(pivot.left), getNodeHeight(pivot.right)) + 1;

        return pivot;
    }

    /**
     *      root                 pivot
     *       / \                  /    \
     *      /   \         ->    root   Beta
     *    gamma  pivot          /  \
     *           /    \       Gamma alpha
     *         alpha  beta
     */
    private AVLTreeNode rotateLeft(AVLTreeNode root) {
        System.out.println("rotating the tree left");
        AVLTreeNode pivot = root.right;
        AVLTreeNode alpha = pivot.left;
        AVLTreeNode beta = pivot.right;
        AVLTreeNode gamma = root.left;

        root.left = gamma;
        root.right =  alpha;
        pivot.left = root;
        pivot.right = beta;

        root.nodeHeight = Mathematical.maximum(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        pivot.nodeHeight = Mathematical.maximum(getNodeHeight(pivot.left), getNodeHeight(pivot.right)) + 1;

        return pivot;
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
