package com.personal;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by pr250155 on 4/12/17.
 */
public class BracesEqualPoint {

    public int findEqualPoint(String expression){
        Map<Integer, Integer> o_reg = new HashMap<>();
        Map<Integer, Integer> c_reg = new HashMap<>();
        int o_cnt = 0 ;
        for(int i = 0 ; i < expression.length(); i++) {
            if(expression.charAt(i) == '(') o_cnt++;
            o_reg.put(i , o_cnt);
        }

        int c_cnt = 0 ;
        for(int i = expression.length()-1 ; i >= 0; i--) {
            if(expression.charAt(i) == ')') c_cnt++;
            c_reg.put(i , c_cnt);
        }

        for(int o : o_reg.keySet()) {
            if(o_reg.get(o) == c_reg.get(o)) return o;
        }

        return 0;
    }
}
