package com.personal;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by prajeeva on 11/2/17.
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> reg = new HashMap<>();
        IntStream.range(0,words.length).forEach(i -> {
            reg.put(words[i] , reg.getOrDefault(words[i],0) + 1 );
        });
        TreeMap<Integer , List<String>> reg2 = new TreeMap<>();
        reg.entrySet().forEach(e -> {
            if(reg2.containsKey(e.getValue())) {
                reg2.get(e.getValue()).add(e.getKey());
            } else {
                List<String> al = new ArrayList<>();
                al.add(e.getKey());
                reg2.put(e.getValue() , al);
            }
        });
        List<String> response = new ArrayList<>();
        NavigableMap<Integer , List<String>> reg3 = reg2.descendingMap();
        int i = 0;
        for(Integer key : reg3.keySet()) {
            if(i == k ) break;
            response.addAll(reg2.get(key));
            i++;
        }
        Collections.sort(response,(o1, o2) -> {
            return o1.compareTo(o2) * -1;
        });
        return response;
    }
}
