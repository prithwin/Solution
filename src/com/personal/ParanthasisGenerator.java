package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 3/31/17.
 */
public class ParanthasisGenerator {
    public static void main(String[] args) {
        List<String> resultSet = new ParanthasisGenerator().generate(3);
        System.out.println(resultSet);
    }

    private List<String> generate(int n) {
        List<String> result = new ArrayList<String>();
        realPermute("",n,n,result);
        return result;
    }

    private void realPermute(String set, int start, int end, List<String> result) {
        if(start > end)
            return;

        if(start == 0 && end == 0){
            result.add(set);
            return;
        }

        if(start > 0 ){
            realPermute(set+"(",start-1,end,result);
        }
        if(end > 0) {
            realPermute(set+")",start,end-1,result);
        }

    }
}
