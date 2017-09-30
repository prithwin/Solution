package com.personal;

import com.personal.util.StackADT;

import java.util.*;

/**
 * Created by prajeev on 15/7/16.
 */
public class ValidateParentheses {

    List<Character> OPENS = Arrays.asList('(','[','{');
    List<Character> CLOSES = Arrays.asList(')',']','}');

    Map<Character,StackADT> registry = new HashMap<>();
    {
        for(int i = 0 ; i < 3 ; i++) {
            StackADT stackADT = new StackADT(30);
            registry.put(OPENS.get(i),stackADT);
            registry.put(CLOSES.get(i),stackADT);
        }
    }
    public boolean isValid(String target) {
        for(int i = 0 ; i < target.length() ; i++) {
            char c = target.charAt(i);
            if(OPENS.contains(c)){
                registry.get(c).push(c);
            } else if(CLOSES.contains(c)) {
                registry.get(c).pop();
            }
        }

        for(char c : OPENS) {
            if(!registry.get(c).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
