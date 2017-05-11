package com.personal.util;

import java.io.Serializable;

/**
 * Created by prajeev on 19/3/17.
 */
public class TreeNode implements Serializable{
    public ComparableNumber number;
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
}
