package com.random.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by prajeev on 16/3/17.
 */
public class MotherOfAlltersterClasses {
    public static void main(String[] args) {
//        Map<Number,String> testMap = new HashMap<Number,String>();
        Map<Number,String> testMap = new TreeMap<Number,String>();
//        Map<Number,String> testMap = new LinkedHashMap<Number,String>();

        testMap.put(new Number(1),"A");
        testMap.put(new Number(4),"A");
        testMap.put(new Number(5),"A");
        testMap.put(new Number(2),"A");
        testMap.put(new Number(3),"A");
        for(Number key : testMap.keySet()){
            System.out.println(key.number);
        }
    }

    static class Number implements Comparable {
        int number;

        Number(int i){
            this.number = i;
        }

        @Override
        public boolean equals(Object obj) {
            Number rhs = (Number)obj;
            return number==rhs.number;
        }


        @Override
        public int compareTo(Object o) {
            Number rhs = (Number)o;
            if (this.number == rhs.number)
                return 0;
            return (this.number-rhs.number)/((this.number-rhs.number)>0? (this.number-rhs.number) : -1*(this.number-rhs.number));
        }
    }
}
