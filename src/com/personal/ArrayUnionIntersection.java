package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 7/16/17.
 */
public class ArrayUnionIntersection {

    /**
     * please make sure what the difference in the implementation is from our end.
     * this is really what separates the boys from the men as we are faster in typing out all this crap and also
     * very fast in making changes to what ever mistatke
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> reg = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int i = 0 ; i < nums1.length ; i++) {
            reg.add(nums1[i]);
        }
        for(int i = 0 ; i < nums2.length ; i++) {
            if(reg.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] response = new int[res.size()];
        int i = 0;
        for(Integer item : res) {
            response[i++] = item;
        }
        return response;
    }

    public int[] intersectionNU(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length ){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> reg = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < nums1.length ; i++) {
            if(!reg.containsKey(nums1[i])) reg.put(nums1[i] , 1);
            else reg.put(nums1[i] , reg.get(nums1[i]) + 1);
        }
        for(int i = 0 ; i < nums2.length ; i++) {
            if(reg.containsKey(nums2[i])) {
                int count  = reg.get(nums2[i]);
                if(count > 0) {
                    res.add(nums2[i]);
                    reg.put(nums2[i] ,count--);
                } else {
                    reg.remove(nums2[i]);
                }
            }
        }
        int[] response = new int[res.size()];
        int i = 0;
        for(Integer item : res) {
            response[i++] = item;
        }
        return response;
    }
}
