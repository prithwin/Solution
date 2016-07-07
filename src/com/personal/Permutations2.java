package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prajeev on 5/7/16.
 */
public class Permutations2 {

    private void realPermute(int[] nums,int[] leadlist,List<List<Integer>> integerMotherLoad){
        if(nums.length==1){
            for(int target: leadlist){
                integerMotherLoad.get(integerMotherLoad.size()-1).add(new Integer(target));
            }
            integerMotherLoad.get(integerMotherLoad.size()-1).add(nums[0]);
            integerMotherLoad.add(new ArrayList<Integer>());
            return;
        }

        for(int i = 0 ; i <nums.length ; i++){
            int[] reminderWithoutlead = getRemainderArray(i,nums);
            realPermute(reminderWithoutlead,mergeArray(leadlist,nums[i]),integerMotherLoad);
        }
    }

    private int[] mergeArray(int[] leadlist, int num) {
        int[] mergedArray = new int[leadlist.length+1];
        for(int i = 0 ; i < leadlist.length ; i++){
            mergedArray[i] = leadlist[i];
        }
        mergedArray[leadlist.length] = num;
        leadlist = null;
        return mergedArray;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> integerMotherLoad = new ArrayList<List<Integer>>();
        integerMotherLoad.add(new ArrayList<Integer>());
        int[] leadlist = {};
        realPermute(nums,leadlist,integerMotherLoad);
        return integerMotherLoad.subList(0,integerMotherLoad.size()-1);
    }

    private int[] getRemainderArray(int i, int[] nums) {
        int[] remainderArray = new int[nums.length-1];
        for(int j = 0 ; j< i ;j++){
            remainderArray[j] = nums[j];
        }
        //add all the ones after i
        for(int j = i+1 ; j< nums.length ;j++){
            remainderArray[j-1] = nums[j];
        }
        return remainderArray;
    }
}
