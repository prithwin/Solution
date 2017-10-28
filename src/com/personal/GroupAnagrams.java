package com.personal;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by prajeeva on 10/21/17.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> reg = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++) {
            if(!reg.containsKey(getSorted(strs[i])))
                reg.put(getSorted(strs[i]) , new ArrayList<>());
            reg.get(getSorted(strs[i])).add(strs[i]);
        }
        List<List<String>> response = new ArrayList<>();
        System.out.println(reg);
        reg.values().stream().forEach(i -> {
            List<String> item = new ArrayList<>();
            item.addAll(i);
            response.add(item);
        });
        return response;
    }

    private String getSorted(String target) {
        char[] ret = target.toCharArray();
        Arrays.sort(ret);
        return new String(ret);
    }
}
