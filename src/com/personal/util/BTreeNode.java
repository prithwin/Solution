package com.personal.util;

/**
 * Created by prith on 15-06-2017.
 */
public class BTreeNode {
    ComparableNumber[] keys;
    BTreeNode[] children;
    int degree;

    /**
     * default acess construction for symettric B tree.
     * @param degree
     */
    public BTreeNode(int degree) {
        this.degree = degree;
        this.keys = new ComparableNumber[this.degree - 1];
        this.children = new BTreeNode[this.degree];
    }
}
