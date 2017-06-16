package com.personal.util;

/**
 * Created by pr250155 on 4/20/17.
 * Hi there, if you find this code online and decide to use it in production,
 * please don't. It's only theoritically verified by me with sparse test cases.
 * please feel free to test this code and add supplementary test case before putting
 * this our there marked as production ready.
 */
public class AVLTree extends BinarySearchTree {
    AVLTreeNode root;

    public void add(AVLTreeNode node) {
        root = addInternal(root, node);
    }

    private AVLTreeNode addInternal(AVLTreeNode where, AVLTreeNode what) {
        if (where == null) {
            return what;
        } else {
            if (what.number.compareTo(where.number) == -1) {
                where.left = addInternal(where.left, what);
            } else if (what.number.compareTo(where.number) == 1) {
                where.right = addInternal(where.right, what);
            } else {
                where.number = what.number;
                return where;
            }
        }

        where.nodeHeight = 1 + Mathematical.maximum(getNodeHeight(where.left), getNodeHeight(where.right));
        return balance(where);
    }

    private AVLTreeNode balance(AVLTreeNode where) {
        if(getBalanceFactor(where) > 1) {
            if(getBalanceFactor(where.right) < 0){
                where.right = rotateRight(where.right);
            }
            where = rotateLeft(where);
        } else if(getBalanceFactor(where) < -1) {
            if(getBalanceFactor(where.left) > 0) {
                where.left = rotateLeft(where.left);
            }
            where = rotateRight(where);
        }
        return where;
    }

    private int getBalanceFactor(AVLTreeNode where) {
        return getNodeHeight(where.right) - getNodeHeight(where.left);
    }

    /**
     * root                 pivot
     * /\                  /    \
     * /  Gamma   ->      alpha   root
     * pivot                        /  \
     * /    \                      Beta Gamma
     * alpha  beta
     */
    private AVLTreeNode rotateRight(AVLTreeNode root) {
        System.out.println("rotating the tree right");
        AVLTreeNode pivot = root.left;
        AVLTreeNode alpha = pivot.left;
        AVLTreeNode beta = pivot.right;
        AVLTreeNode gamma = root.right;

        root.left = beta;
        root.right = gamma;
        pivot.left = alpha;
        pivot.right = root;

        root.nodeHeight = Mathematical.maximum(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        pivot.nodeHeight = Mathematical.maximum(getNodeHeight(pivot.left), getNodeHeight(pivot.right)) + 1;

        return pivot;
    }

    /**
     * root                 pivot
     * / \                  /    \
     * /   \         ->    root   Beta
     * gamma  pivot          /  \
     * /    \       Gamma alpha
     * alpha  beta
     */
    private AVLTreeNode rotateLeft(AVLTreeNode root) {
        AVLTreeNode pivot = root.right;
        AVLTreeNode alpha = pivot.left;
        AVLTreeNode beta = pivot.right;
        AVLTreeNode gamma = root.left;

        root.left = gamma;
        root.right = alpha;
        pivot.left = root;
        pivot.right = beta;

        root.nodeHeight = Mathematical.maximum(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        pivot.nodeHeight = Mathematical.maximum(getNodeHeight(pivot.left), getNodeHeight(pivot.right)) + 1;

        return pivot;
    }

    private int getNodeHeight(AVLTreeNode node) {
        if (node == null)  return -1;
        return node.nodeHeight;
    }

    public void printAVLTree() {
        printAvlTreeInOrder(root);
    }

    private void printAvlTreeInOrder(AVLTreeNode node) {
        if (node == null)
            return;
        printAvlTreeInOrder(node.left);
        System.out.println(node.number + "->" + node.nodeHeight);
        printAvlTreeInOrder(node.right);
    }

    public void remove(AVLTreeNode node) {
        deleteNode(root,node);
    }

    private AVLTreeNode deleteNode(AVLTreeNode where, AVLTreeNode what) {
        if(what.number.compareTo(where.number) == -1) {
            where.left = deleteNode(where.left, what);
        } else if(what.number.compareTo(where.number) == 1) {
            where.right = deleteNode(where.right,what);
        } else {
            if(where.left == null) {
                return where.right;
            } else if(where.right == null) {
                return where.left;
            } else {
                AVLTreeNode temp = where;
                where.number = min(temp.right).number;
                where.left = temp.left;
                where.right = deleteMin(temp.right);
            }
        }
        where.nodeHeight = 1 + Mathematical.maximum(getNodeHeight(where.left), getNodeHeight(where.right));
        return balance(where);
    }

    private AVLTreeNode deleteMin(AVLTreeNode where) {
        if(where.left == null) return where.right;
        where.left = deleteMin(where.left);
        where.nodeHeight = 1 + Mathematical.maximum(getNodeHeight(where.left), getNodeHeight(where.right));
        return balance(where);
    }

    private AVLTreeNode min(AVLTreeNode node) {
        if(node.left == null)
            return node;
        return min(node.left);
    }
}
