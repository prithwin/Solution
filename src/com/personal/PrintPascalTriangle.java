package com.personal;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by prajeeva on 9/16/17.
 */
public class PrintPascalTriangle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        for(int i = 0 ; i < 10 ; i++) {
            List<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            for(int j = 1 ; j < list.size(); j++) {
                nextList.add(list.get(j-1) + list.get(j));
            }
            nextList.add(1);
            System.out.println(nextList);
            list = nextList;
        }
        System.out.println(0+'0');

    }
}
