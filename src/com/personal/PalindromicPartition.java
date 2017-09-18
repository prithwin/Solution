package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajeeva on 9/17/17.
 */
public class PalindromicPartition {
    public List<List<String>> partition(String target) {
        List<List<String>> response = new ArrayList<>();
        fill(new ArrayList<>(), target , response);
        return response;
    }

    private void fill( List<String> lead ,String target , List<List<String>> response) {
        if(target.length() == 0) {
            List<String> cache = new ArrayList<>();
            cache.addAll(lead);
            response.add(cache);
        } else {
            for(int i = 0 ; i < target.length() ; i++) {
                lead.add(target.substring(0,i+1));
                if(isPalindrome(target.substring(0,i+1))) {
                    fill(lead,target.substring(i+1) , response);
                }
                lead.remove(lead.size() -1);
            }
        }
    }

    private boolean isPalindrome(String target) {
        int start = 0 , end = target.length() -1;
        while(start < end) {
            if(target.charAt(start) != target.charAt(end)) return false;
            start++;end--;
        }
        return true;
    }

}
