package com.java.rules;

import com.personal.util.TreeNode;

import java.util.*;

/**
 * Created by prajeeva on 11/3/17.
 */
public class OptionalRules {
    public static void main(String[] args) {
        //call a method that returns an optional value
    }

    public static Optional<String> getMyFrindsName(int num){
        if(num%2==0) return Optional.ofNullable(null);
        return Optional.ofNullable("Freddy Mercury");
    }
}
