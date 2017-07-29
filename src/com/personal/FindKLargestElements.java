package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 7/28/17.
 */
public class FindKLargestElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer , Integer> reg = new HashMap<>();
        for(int num : nums) {
            reg.put(num , reg.getOrDefault(num , 0) + 1);
        }

        for(int key : reg.keySet()) {
            int index = reg.get(key);
            if(bucket[index] == null) bucket[index] = new ArrayList<>();
            bucket[index].add(key);
        }
        List<Integer> response = new ArrayList<>();
        for(int i = bucket.length - 1 ; i >=0 && response.size() < k ; i--) {
            if(bucket[i]!=null) response.addAll(bucket[i]);
        }
        return response;
    }
}
