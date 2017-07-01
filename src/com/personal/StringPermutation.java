package com.personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pr250155 on 3/31/17.
 * p(,ABCD)
 * <p>
 * p(A,BCD)             p(B,ACD)    p(C,ABD)    p(D,ABC)
 * p(AB,CD) p(AC,BD) p(AD,BC)
 * [ABCD ABDC ACBD ACDB ADBC ADCB] = 6 * 4 = 24 such combination
 * efficiency is o(n!).
 */
public class StringPermutation {

    public List<String> permute(String target) {
        List<String> result = new ArrayList<>();
        String lead = "";
        realPermute(lead, target, result);
        return result;
    }

    private void realPermute(String lead, String target, List<String> result) {
        if (target.length() == 1) {
            String output = lead + target;
            result.add(output);
            return;
        }
        for (int i = 0; i < target.length(); i++) {
            realPermute(lead + target.charAt(i)
                    , target.substring(0, i) + target.substring(i + 1, target.length()),
                    result);
        }
    }
}
