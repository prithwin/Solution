package com.personal;

import java.util.Stack;

/**
 * Created by prajeeva on 11/1/17.
 */
public class DecodeString {

    String decodeString(String s) {
        Stack<String> m = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i)!=']') m.push(""+s.charAt(i));
            else {
                StringBuilder t = new StringBuilder();
                String p;
                while(!(p = m.pop()).equals("[")) {
                    t.append(p+",");
                }
                StringBuilder ft = new StringBuilder();
                String[] tokens = t.toString().split(",");
                for(int k = tokens.length - 1; k >=0 ; k--) {
                    ft.append(tokens[k]);
                }
                StringBuilder numb = new StringBuilder();
                while(!m.isEmpty() && isNumber(m.peek())) numb.append(m.pop());
                numb.reverse();
                int n = Integer.parseInt(numb.toString());
                StringBuilder part = new StringBuilder();
                for(int j = 0 ; j < n ; j++) {
                    part.append(ft);
                }
                m.push(part.toString());
            }
        }
        if(s.isEmpty()) return "";
        return m.stream().reduce((a,b) -> a+b).get();
    }

    private boolean isNumber(String s) {
        return s.charAt(0) >= '0' && s.charAt(0)<='9';
    }

}
