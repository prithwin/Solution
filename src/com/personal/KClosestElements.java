package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/16/17.
 */
public class KClosestElements {
    public List<Integer> findKClosestElements(List<Integer> target , int k,int value){
        List<Integer> response = new ArrayList<>();
        if( value > target.get(target.size()-1)){
            response.add(target.get(target.size()-1));
            response.add(target.get(target.size()-2));
            response.add(target.get(target.size()-3));
            response.add(target.get(target.size()-4));
        } else if(value < target.get(0)){
            response.add(target.get(0));
            response.add(target.get(1));
            response.add(target.get(2));
            response.add(target.get(3));
        } else {
            int crosssOverpoint = RandomDnQ.binarySearchforCrossOverPoint(target, value);
            for(int i=crosssOverpoint, j=crosssOverpoint;response.size()<4;){
                if(i==crosssOverpoint || j==crosssOverpoint){
                    i--;j++;
                    continue;
                }
                if(j > target.size() && i >=0 ){
                    response.add(target.get(i--));
                    continue;
                } else if(i < 0 && j <= target.size()-1){
                    response.add(target.get(j++));
                    continue;
                } else {
                    int ldiff = Math.abs(value-target.get(i));
                    int rdiff = Math.abs(value-target.get(j));
                    if(ldiff<=rdiff){
                        response.add(target.get(i--));
                    } else {
                        response.add(target.get(j++));
                    }
                }

            }
        }
        return response;
    }

    public static void main(String[] args) {
        new KClosestElements().findKClosestElements(Arrays.asList(12, 16, 22, 30, 34, 39, 42
                ,45, 48, 50, 53, 55, 56) , 4 , 35).stream().forEach(System.out::println);
    }
}
