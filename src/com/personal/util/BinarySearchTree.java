package com.personal.util;

import sun.reflect.generics.tree.Tree;

import java.io.Serializable;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by pr250155 on 3/24/17.
 */
public class BinarySearchTree extends BinaryTree implements Serializable {

    public void add(TreeNode node) {
        root = add(root, node);
    }

    @Override
    public int getMinValue() {
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.number.number;
    }

    @Override
    public int getMaxValue() {
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.number.number;
    }

    private TreeNode add(TreeNode where, TreeNode what) {
        if (where == null) return what;
        if (what.number.compareTo(where.number) == -1) {
            where.left = add(where.left, what);
        } else if (what.number.compareTo(where.number) == 1) {
            where.right = add(where.right, what);
        } else {
            where.number = what.number;
        }
        return where;
    }

    @Override
    public TreeNode getLowestCommonAncestor(TreeNode thiz, TreeNode dat) {
        return getLCABST(root, thiz, dat);

    }

    private TreeNode getLCABST(TreeNode currentRoot, TreeNode thiz, TreeNode dat) {
        if (thiz.number.compareTo(currentRoot.number) == -1 &&
                dat.number.compareTo(currentRoot.number) == 1) {
            return currentRoot;
        } else if (thiz.number.compareTo(currentRoot.number) == -1 &&
                dat.number.compareTo(currentRoot.number) == -1 && thiz.left != null) {
            return getLCABST(currentRoot.left, thiz, dat);
        } else {
            return getLCABST(currentRoot.right, thiz, dat);
        }
    }

    public void balanceBST() {
        List<TreeNode> flattenedList = new LinkedList<>();
        inOrderAddToList(root, flattenedList);
        int mid = (flattenedList.size() - 1) / 2;
        int i = 0, j = 0;
        BinarySearchTree balancedBst = new BinarySearchTree();
        if (flattenedList.size() % 2 == 0) {
            i = mid;
            j = i + 1;
        } else {
            balancedBst.add(new TreeNode(flattenedList.get(mid).number.number));
            i = mid - 1;
            j = mid + 1;
        }
        BinarySearchTree BalancedBst = new BinarySearchTree();
        while (true) {
            if (i < 0 && j > flattenedList.size() - 1) {
                break;
            }
            if (i >= 0) {
                balancedBst.add(new TreeNode(flattenedList.get(i--).number.number));
            }
            if (j <= flattenedList.size() - 1) {
                balancedBst.add(new TreeNode(flattenedList.get(j++).number.number));
            }
        }
        this.root = balancedBst.root;
    }

    private void inOrderAddToList(TreeNode node, List<TreeNode> flattenedList) {
        if (node == null) {
            return;
        }
        inOrderAddToList(node.left, flattenedList);
        flattenedList.add(node);
        inOrderAddToList(node.right, flattenedList);
    }

    @Override
    public void remove(TreeNode node) {
        root = deleteNode(root, node);
    }

    private TreeNode deleteNode(TreeNode where, TreeNode what) {
        if (what.number.compareTo(where.number) == -1) {
            where.left = deleteNode(where.left, what);
        } else if (what.number.compareTo(where.number) == 1) {
            where.right = deleteNode(where.right, what);
        } else {
            if (where.left == null) {
                return where.right;
            } else if (where.right == null) {
                return where.left;
            } else {
                TreeNode temp = where;
                where.number = min(temp.right).number;
                where.left = temp.left;
                where.right = deleteMin(temp.right);
            }
        }
        return where;
    }

    protected TreeNode min(TreeNode where) {
        if (where.left == null)
            return where;
        return min(where.left);
    }

    protected TreeNode deleteMin(TreeNode where) {
        if (where.left == null) return where.right;
        where.left = deleteMin(where.left);
        return where;
    }

    public void trim(int low , int high) {
        ComparableNumber l = new ComparableNumber(low);
        ComparableNumber h = new ComparableNumber(high);
        root = trimInternal(root , l , h);
    }

    private TreeNode trimInternal(TreeNode node , ComparableNumber low , ComparableNumber high) {
        if(node == null) return node;
        if(node.number.compareTo(low) == -1) {
            return trimInternal(node.right , low , high);
        } else if(node.number.compareTo(high) == 1) {
            return trimInternal(node.left , low , high);
        } else {
            node.left = trimInternal(node.left , low , high);
            node.right = trimInternal(node.right, low , high);
            return node;
        }
    }

}
