package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 3/31/17.
 */
public class ArrayPermutations {
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        List<List<Integer>> resultList = new ArrayPermutations().permute(inputList);
        resultList.forEach(System.out::println);
    }

    private List<List<Integer>> permute(List<Integer> target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> leadList = new ArrayList<>();
        realPermute(leadList,target,resultList);
        return resultList;
    }


    private void realPermute(List<Integer> leadList, List<Integer> target , List<List<Integer>> resultList) {
        if(target.size() == 1){
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(leadList);
            temp.addAll(target);
            resultList.add(temp);
        } else {
                for (int i = 0; i < target.size(); i++) {
                Integer nextSeries = target.get(i);
                leadList.add(nextSeries);
                target.remove(i);
                realPermute(leadList, target, resultList);
                target.add(i,nextSeries);
                leadList.remove(leadList.size()-1);
            }
        }
    }
}
