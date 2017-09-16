package com.personal;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by prajeeva on 9/13/17.
 */
public class PhoneDigits {
    public List<String> getCombinations(String number) {
        List<String> response = new ArrayList<>();
        List<String> dialPad = Arrays.asList(   "0", "1" , "abc"
                                                ,"def" ,"ghi" , "jkl","mno" ,
                                                "pqrs","tuv","wxyz");
        combine("" , number, dialPad , response);
        return response;
    }

    private void combine(String buf , String number , List<String> dialPad , List<String> response) {
        if(number.length() == 0) {
            response.add(buf);
        } else {
            Integer lookup = Integer.parseInt(""+number.charAt(0));
            //lookup = 2
            String key = dialPad.get(lookup);
            for(int i = 0 ; i < key.length() ; i++) {
                combine(buf + key.charAt(i) , number.substring(1) , dialPad , response);
            }
        }
    }
}
