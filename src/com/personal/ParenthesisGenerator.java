package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 3/31/17.
 * PG(set,nS,nE){
 *     if(nS > nE) {return}
 *     if(ns == nE == 0)
 *      Sout >> set;
 *      if(ns>0)
 *          PG(set+"(",ns-1,nE);
 *      if(nE > 0)
 *          PG(set+")",ns,nE-1);
 * }
 *
 */
public class ParenthesisGenerator {

    public List<String> generate(int n) {
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
