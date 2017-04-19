package com.personal;

import com.personal.util.Mathematical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/18/17.
 *     a   b   c         d
 *  a  0   1   1         d
 *  b  a   ab  ab,bc,ca
 *  d
 *  d
 */
public class CalculatePowerSet {
    public List<List<Character>> getPowerSet(List<Character> target) {
        List<List<Character>> responseSet = new ArrayList<>();
        int powerSetSize = Mathematical.power(2,target.size());
        for(int i = 1 ; i < powerSetSize ; i++) {
            List<Integer> binaryRepresentation = Mathematical.getBinaryRepresentationAsAList(i,target.size());
            List<Character> set = new ArrayList<>();
            for(int j = 0 ; j < binaryRepresentation.size() ; j++){
                if(binaryRepresentation.get(j) == 1){
                    set.add(target.get(j));
                }
            }
            responseSet.add(set);
        }
        return responseSet;
    }


    public static void main(String[] args) {
        new CalculatePowerSet().getPowerSet(Arrays.asList('a', 'b', 'c')).stream().forEach(System.out::println);
    }

}
