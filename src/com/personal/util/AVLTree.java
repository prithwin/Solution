package com.personal.util;

/**
 * Created by pr250155 on 4/20/17.
 * Hi there, if you find this code online and decide to use it in production,
 * please don't. It's only theoritically verified by me with sparse test cases.
 * please feel free to test this code and add supplementary test case before putting
 * this our there marked as production ready.
 *
 *
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
            if (balance > 1 && isBalanceType(where,BalanceType.LL)) {
                return rotateRight(where);
            }

            //LR case
            if (balance > 1 && isBalanceType(where,BalanceType.LR)) {
                where.left = rotateLeft(where.left);
                return rotateRight(where);
            }

            //RR Case
            if (balance < -1 && isBalanceType(where,BalanceType.RR)) {
                return rotateLeft(where);
            }

            //RL CASE
            if (balance < -1 && isBalanceType(where,BalanceType.RL)) {
                where.right = rotateRight(where.right);
                return rotateLeft(where);
            }
            return where;
        }
    }

    private boolean isBalanceType(AVLTreeNode node, BalanceType balanceType) {
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


    public void remove(AVLTreeNode node) {
        if(node.equals(this.root)){
            AVLTreeNode phantom = new AVLTreeNode(0,true);
            if(root.number.number > 0) {
                phantom.right = root;
                removeInternal(phantom, phantom.right,node);
                this.root = phantom.right;
            } else {
                phantom.left = root;
                removeInternal(phantom, phantom.left,node);
                this.root = phantom.left;
            }
        } else if(this.root.left!=null && node.number.compareTo(this.root.number) <=0) {
            removeInternal(this.root,this.root.left, node);
        } else if(this.root.right!=null && node.number.compareTo(this.root.number) >= 0 ) {
            removeInternal(this.root,this.root.right,node);
        }
    }

    private AVLTreeNode removeInternal(AVLTreeNode penultimate , AVLTreeNode ultimate , AVLTreeNode node) {
        if(ultimate == null) return ultimate;
        if(ultimate.equals(node)) {
            if(ultimate.left == null && ultimate.right == null) {
                transplant(penultimate,ultimate , null);
            }
            else if(ultimate.left == null || ultimate.right == null){
                if(ultimate.left != null) {
                    transplant(penultimate,ultimate,ultimate.left);
                } else {
                    transplant(penultimate,ultimate ,ultimate.right);
                }
            } else {
                AVLTreeNode rLargest = ultimate.right;
                AVLTreeNode rLargetp = penultimate.right;
                ultimate.number = rLargest.number;
                return removeInternal(rLargetp,rLargest,new AVLTreeNode(rLargest.number.number));
            }
            return ultimate;
        }
        if(ultimate.left!=null && node.number.compareTo(ultimate.number) <= 0){
            if(penultimate.left!=null && node.number.compareTo(penultimate.number) <= 0) {
                return removeInternal(penultimate.left, ultimate.left, node);
            } else {
                return removeInternal(penultimate.right, ultimate.left, node);
            }
        }
        if(ultimate.right!=null && node.number.compareTo(ultimate.number) == 1){
            if(penultimate.right!=null && node.number.compareTo(penultimate.number) == 1) {
                return removeInternal(penultimate.right, ultimate.right, node);
            } else {
                return removeInternal(penultimate.left, ultimate.right, node);
            }
        }
        ultimate.nodeHeight = 1 +  Mathematical.maximum(getNodeHeight(ultimate.left),getNodeHeight(ultimate.right));
        int balance = getNodeHeight(ultimate.left) -  getNodeHeight(ultimate.right);

        //LL case
        if (balance > 1 && isBalanceType(ultimate,BalanceType.LL)) {
            return rotateRight(ultimate);
        }

        //LR case
        if (balance > 1 && isBalanceType(ultimate,BalanceType.LR)) {
            ultimate.left = rotateLeft(ultimate.left);
            return rotateRight(ultimate);
        }

        //RR Case
        if (balance < -1 && isBalanceType(ultimate,BalanceType.RR)) {
            return rotateLeft(ultimate);
        }

        //RL CASE
        if (balance < -1 && isBalanceType(ultimate,BalanceType.RL)) {
            ultimate.right = rotateRight(ultimate.right);
            return rotateLeft(ultimate);
        }
        return ultimate;
    }

    private void transplant(AVLTreeNode penultimate, AVLTreeNode ultimate, AVLTreeNode replacement) {
        if(penultimate.left!=null) {
            if (penultimate.left.equals(ultimate)) {
                penultimate.left = replacement;
            }
        }
        if(penultimate.right!=null) {
            if (penultimate.right.equals(ultimate)) {
                penultimate.right = replacement;
            }
        }
    }
}
