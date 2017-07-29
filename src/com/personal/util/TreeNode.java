package com.personal.util;

import java.io.Serializable;

/**
 * Created by prajeev on 19/3/17.
 */
public class TreeNode implements Serializable{
    public ComparableNumber number;
    public Entry<Integer, Integer> entry;
    public String data;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int number){
        ComparableNumber comparableNumber = new ComparableNumber(number);
        this.number = comparableNumber;
    }

    public TreeNode(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof TreeNode){
            TreeNode that = (TreeNode) obj;
            if(this.number.equals(that.number)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if(number!=null)
            return number.toString();
        else
            return data;
    }

    public static TreeNode merge(TreeNode thiz, TreeNode that) {
        if(thiz == null) return that;
        if(that == null) return thiz;
        TreeNode node = new TreeNode(thiz.number.number + that.number.number);
        node.left = merge(thiz.left , that.left);
        node.right = merge(thiz.right , that.right);
        return node;
    }
}
