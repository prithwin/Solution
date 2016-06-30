package com.personal;

/**
 * Created by pr250155 on 2/14/16.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s.length()<3 || numRows<3)
            return s;
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int rgap = 0;
        int lgap = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < chars.length) {
                if (j == i)
                    builder.append(chars[j]);
                if (lgap != 0 && j + lgap <= chars.length - 1)
                    builder.append(chars[j + lgap]);
                if (rgap != 0 && j + lgap + rgap <= chars.length - 1)
                    builder.append(chars[j + lgap + rgap]);
                j = j + lgap + rgap;


            }
            lgap = lgap - 2;
            rgap = rgap + 2;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.print(new ZigZagConversion().convert("ABC", 1));
    }
}
