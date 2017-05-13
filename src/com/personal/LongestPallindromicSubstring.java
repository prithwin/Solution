package com.personal;

/**
 * Created by prajeev on 13/3/17.
 */
public class LongestPallindromicSubstring {

    public String find(String target) {
        char[] targetArray = target.toCharArray();
        int longestOverAll = 0;
        int xstart=0;
        int xend=0;
        for (int i = 0; i <targetArray.length; i++) {
            int j = i-1;
            int longestOddValue = 1;
            int k = i+1;
            while(j>=0 && k<=targetArray.length-1 && targetArray[j]==targetArray[k]){
                longestOddValue+=2;
                j--;
                k++;
            }
            if(longestOddValue> longestOverAll){
                longestOverAll = longestOddValue;
                xstart = j;
                xend = k;
            }

            j = i;
            k = i+1;
            int longestEvenValue = 0;
            while (j>=0 && k<=targetArray.length-1 && targetArray[j]==targetArray[k] ){
                longestEvenValue+=2;
                j--;
                k++;
            }

            if(longestEvenValue> longestOverAll){
                longestOverAll = longestEvenValue;
                xstart = j;
                xend = k;
            }

        }
        return target.substring(xstart+1,xend);
    }
}
