package com.personal.util;

/**
 * Created by prith on 12-06-2017.
 * TODO: This implementation is not complete and cannot really be used at production level.
 */
public class RedBlackTreeNode extends TreeNode{
    ComparableNumber number;
    RedBlackTreeNode left;
    RedBlackTreeNode right;
    RedBlackTreeNode parent;
    boolean isSentinel;
    boolean isBlack;

    public RedBlackTreeNode(int number) {
        super(number);
        this.number = new ComparableNumber(number);
        this.left = null;
        this.right = null;
        this.isBlack = false;
        this.isSentinel = false;
    }

    public RedBlackTreeNode(boolean isSentinel){
        super(0);
        this.isBlack = true;
        this.isSentinel = true;
    }

    @Override
    public String toString() {
        if(isSentinel) return "S";
        return number +  ((isBlack)?" -> BLACK" : " -> RED");
    }
}
