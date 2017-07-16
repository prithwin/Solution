package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 7/15/17.
 */
public class PermutationWithRepeats {

    Set<List> registry = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        List<Integer> lead = new ArrayList();
        permute(lead , nums, response);
        return response;
    }

    private void permute(List<Integer> lead , int[] rem , List<List<Integer>> response) {
        if(rem.length == 1) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(lead);
            newList.add(rem[0]);
            addIfAbsent(response , newList);
            return;
        }
        for( int i = 0 ; i < rem.length ; i++) {
            lead.add(rem[i]);
            int[] rest = getReminder(rem , i);
            permute(lead, rest , response);
            lead.remove(lead.size() - 1);
        }
    }

    private int[] getReminder(int[] nums , int k) {
        int[] response = new int[nums.length - 1];
        for (int i = 0,j=0 ; i < nums.length ; i++) {
            if(i != k) {
                response[j++] = nums[i];
            }
        }
        return response;
    }

    private void addIfAbsent(List<List<Integer>> response , List<Integer> item) {
        if(!registry.contains(item)) {
            response.add(item);
            registry.add(item);
        }
    }
}
