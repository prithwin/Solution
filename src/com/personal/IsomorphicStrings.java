package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 10/22/17.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!= t.length()) return false;
        Map<Character , List<Integer>> map = new LinkedHashMap<>();
        Map<Character , List<Integer>> m2 = new LinkedHashMap<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i) , new ArrayList<>());
            map.get(s.charAt(i)).add(i);
        }


        for(int i = 0 ; i < t.length() ; i++) {
            if(!m2.containsKey(t.charAt(i))) m2.put(t.charAt(i) , new ArrayList<>());
            m2.get(t.charAt(i)).add(i);
        }
        return map.values().stream().collect(ArrayList::new , ArrayList::add, ArrayList::add)
                .equals(m2.values().stream().collect(ArrayList::new,ArrayList::add , ArrayList::add));
    }
}
