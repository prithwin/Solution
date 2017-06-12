package com.personal.util;

/**
 * Created by prith on 12-06-2017.
 * TODO: This implementation is not complete and cannot really be used at production level.
 */
public class RedBlackTreeNode extends TreeNode{
    ComparableNumber number;
    RedBlackTreeNode left;
    RedBlackTreeNode right;
    boolean isBlack;

    public RedBlackTreeNode(int number, boolean isBlack) {
        super(number);
        this.number = new ComparableNumber(number);
        this.left = null;
        this.right = null;
        this.isBlack = isBlack;
    }
}
