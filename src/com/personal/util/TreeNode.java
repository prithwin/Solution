package com.personal.util;

import java.io.Serializable;

/**
 * Created by prajeev on 19/3/17.
 */
public class TreeNode implements Serializable{
    public ComparableNumber number;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int number){
        ComparableNumber comparableNumber = new ComparableNumber(number);
        this.number = comparableNumber;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof TreeNode){
            TreeNode that = (TreeNode) obj;
            if(this.number == that.number){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
