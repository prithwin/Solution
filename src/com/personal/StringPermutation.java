package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 3/31/17.
 */
public class StringPermutation {

    public static void main(String[] args) {
        String target = "ABCD";
        List<String> result = new StringPermutation().permute(target);
        System.out.println(result);
    }

    private List<String> permute(String target) {
        List<String> result = new ArrayList<>();
        String lead = "";
        realPermute(lead,target,result);
        return result;
    }

    private void realPermute(String lead, String target, List<String> result) {
        if(target.length()==1){
            String output = lead+target;
            result.add(output);
        } else {
            for(int i = 0 ; i < target.length() ; i++) {
                String nextLead = lead + target.charAt(i);
                String targetWithoutLead = target.substring(0,i) + target.substring(i+1,target.length());
                realPermute(nextLead,targetWithoutLead,result);
            }
        }
    }
}
