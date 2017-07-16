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

   public List<String> generateParenthesis(int n) {
       List<String> response = new ArrayList<>();
       generate("",n,n,response);
       return response;
   }

   private void generate(String curr , int st, int en , List<String> response) {
       if(st > en) return;
        if(st ==0 && en ==0) {
            response.add(curr);
        }
        if(st > 0) generate(curr + "(" , st - 1 , en, response);
        if(en > 0) generate(curr + ")" , st , en - 1 ,response);
   }


}
