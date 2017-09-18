package com.personal;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by prajeeva on 9/17/17.
 */
public class GreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            result.add(i ^ i>>1);}
        return result;
    }
}
