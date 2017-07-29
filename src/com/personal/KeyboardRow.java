package com.personal;

import java.util.*;

/**
 * Created by prajeeva on 7/29/17.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        Set<Character> top = new HashSet<>();
        Set<Character> mid = new HashSet<>();
        Set<Character> end = new HashSet<>();
        top.addAll(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        mid.addAll(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        end.addAll(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        List<String> response = new ArrayList<>();
        for (String word : words) {
            int t = 0, m = 0, e = 0;
            for (Character c : word.toLowerCase().toCharArray()) {
                if (top.contains(c)) t++;
                if (mid.contains(c)) m++;
                if (end.contains(c)) e++;
            }
            if ((t == word.length() && m == 0 && e == 0)
                    ||
                    (t == 0 && m == word.length() && e == 0)
                    ||
                    (t == 0 && m == 0 && e == word.length())) {
                response.add(word);
            }
        }
        String[] res = new String[response.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = response.get(i);
        }
        return res;
    }
}
