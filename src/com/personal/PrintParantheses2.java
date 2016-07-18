package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeev on 15/7/16.
 */
public class PrintParantheses2 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        parenthesize(result,"",n,n);
        return result;

    }

    private void parenthesize(ArrayList<String> result, String s, int left, int right) {
        if(left>right){
            return;
        }
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }

        if(left > 0){
            parenthesize(result,s+"(",left-1,right);
        }

        if(right > 0){
            parenthesize(result,s+")",left,right-1);
        }
    }

    public static void main(String[] args){
        List<String> jam = new PrintParantheses2().generateParenthesis(5);
        System.out.println(jam);
    }
}
