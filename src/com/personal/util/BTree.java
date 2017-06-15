package com.personal.util;

/**
 * Created by prith on 15-06-2017.
 */
public class BTree {
    BTreeNode root;
    int degree;

    public BTree(int degree) {
        this.degree = degree;
        root = new BTreeNode(degree);
    }
}
