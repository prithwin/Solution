package com.personal.util;

/**
 * Created by pr250155 on 4/20/17.
 */
public class AVLTreeNode extends TreeNode {
    
    ComparableNumber number;
    AVLTreeNode left;
    AVLTreeNode right;
    int nodeHeight;
    boolean phantom;

    public AVLTreeNode(int number) {
        super(number);
        this.number = new ComparableNumber(number);
        this.phantom = false;
    }

    public AVLTreeNode(int number,boolean isPhantom) {
        super(number);
        this.number = new ComparableNumber(number);
        this.phantom = isPhantom;
    }
}
