package com.personal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pr250155 on 5/29/17.
 */
public class PermutationsAndCombinations<E> {

    private final static String BLANK = "";

    /**
     * magical method that computes ncr.
     * @param items the list of items
     * @param size the size of the items.
     * @return a set of unite items that contains all combinations of r size in the above list
     */
    public Set<String> C(List<E> items, int size) {
        Set<String> result = new HashSet<>();
        nCr(BLANK,items,size,result);
        return result;
    }

    public void pascalTriangle() {
        for (int n = 0; n < 10; n++) {
            int nCk = 1;
            for (int k = 0; k <= n; k++) {
                System.out.print(nCk + " ");
                nCk = nCk / ((n-k) *(k));
            }
            System.out.println();
        }
    }

    /**
     * The algorithm can be summarized as shown below.
     * nCr(L , V, R) {
     *     if(R > V.size) return -- combination not possible
     *     if(V.size == 0) return -- such a combination not possible.
     *
     *     if(R==V.size) {
     *         if(L is BLANK) {
     *             sout V;
     *         } else {
     *             sout L+V;
     *         }
     *     } else {
     *         for(V[i] in V) {
     *             nCr(V[i] , V-(V[i]) , r - 1);
     *             nCr( BLANK , V-(V[i]) , r);
     *         }
     *     }
     * }
     */
    private void nCr(String lead, List<E> items, int size, Set<String> result) {
        if(size > items.size()) return;

        if(size == 0) return;

        if(size == items.size() && lead.equals(BLANK)) {
            StringBuilder stringBuilder = new StringBuilder();
            for(E item : items) {
                stringBuilder.append(item.toString());
            }
            result.add(stringBuilder.toString());
        } else if(items.size() == size - 1  && !lead.equals(BLANK)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(lead);
            for(E item : items) {
                stringBuilder.append(item.toString());
            }
            result.add(stringBuilder.toString());
        } else {
            for(int i = 0 ; i < items.size() ; i++) {
                List<E> remainderList = getListExcluding(items, i);
                nCr(items.get(i).toString(),remainderList,size ,result);
                nCr(BLANK,remainderList,size,result);
            }
        }
    }

    public Set<String> P(List<E> items, int size) {
        Set<String> combinations = new HashSet<>();
        nCr(BLANK,items,size,combinations);
        Set<String> permutations = new HashSet<>();
        for(String combination : combinations) {
            permutations.addAll(new StringPermutation().permute(combination));
        }
        return permutations;

    }

    private List<E> getListExcluding(List<E> items, int index) {
        List<E> returnList = new ArrayList<>();
        for(int i = 0 ; i < items.size() ; i++) {
            if(i != index) returnList.add(items.get(i));
        }
        return returnList;
    }
}
