package com.personal;

/**
 * Created by pr250155 on 2/6/16.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int inputLength = s.length();
        //initialize a boolean cache of something is a pallindrome
        boolean cache[][] = new boolean[inputLength+1][inputLength+1];
        //initializes the max length
        int maxLength = 0;
        int start = 0;
        //mark all the 1 sized elements true
        for(int i=0 ; i<inputLength ;i++){
            cache[i][1] = true;
            maxLength=1;
        }
        for (int i=0 ; i<inputLength-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                start = i;
                cache[i][2] = true;
                maxLength = 2;
            }
        }

        //find the larger lengths.

        for (int l = 3; l <= inputLength; l++) {
            //start from the first char
            for (int i = 0; i <= inputLength - l; i++) {
                //check if the extremities match and the innnerds too match
                if(s.charAt(i)==s.charAt(i+l-1) && cache[i+1][l-2]){
                    cache[i][l] = true;
                    if(l>maxLength){
                        start = i;
                        maxLength=l;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);

    }

}
