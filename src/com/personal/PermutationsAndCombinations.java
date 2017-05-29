package com.personal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pr250155 on 5/29/17.
 */
public class PermutationsAndCombinations<E> {

    private final static String COMMA = ",";
    private final static String BLANK = "";

    public Set<String> C(List<E> items, int size) {
        Set<String> result = new HashSet<>();
        nCr(BLANK,items,size,result);
        return result;
    }

    private void nCr(String lead, List<E> items, int size, Set<String> result) {
        if(size > items.size()) return;

        if(size == 0) return;

        if(size == items.size() && lead.equals(BLANK)) {
            StringBuilder stringBuilder = new StringBuilder();
            for(E item : items) {
                stringBuilder.append(item.toString()).append(COMMA);
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            result.add(stringBuilder.toString());
        } else if(items.size() == size - 1 && !lead.equals(BLANK)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(lead);
            for(E item : items) {
                stringBuilder.append(item.toString()).append(COMMA);
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            result.add(stringBuilder.toString());
        } else {
            for(int i = 0 ; i < items.size() ; i++) {
                List<E> remainderList = getListExcluding(items, i);
                nCr(items.get(i).toString(),remainderList,size,result);
                nCr(BLANK,remainderList,size,result);
            }
        }
    }

    private List<E> getListExcluding(List<E> items, int index) {
        List<E> returnList = new ArrayList<>();
        for(int i = 0 ; i < items.size() ; i++) {
            if(i != index) returnList.add(items.get(i));
        }
        return returnList;
    }
}
