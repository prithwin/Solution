package com.personal;

/**
 * Created by pr250155 on 5/25/17.
 */
public class PallindromicPossibilities {
    public void printPallindromicPossiblities(String target) {
        for(int i = 0 ; i < target.length() ; i++) {
            //check for odd Length palindromes here
            int j = i , k = i ;
            while(j >= 0 && k < target.length()) {
                if(isPallindrome(target,j,k)){
                    System.out.println(target.substring(j,k+1));
                }
                j--;k++;
            }

            //check or even length palindromes
            j = i;
            k = i + 1;
            while(j >= 0 && k < target.length()) {
                if(isPallindrome(target,j,k)) {
                    System.out.println(target.substring(j,k));
                }
                j--;k++;
            }
        }
    }

    private boolean isPallindrome(String target,int start , int end) {
        for(int i = start , j = end ; i < j ; i++,j--) {
            if(target.charAt(i) != target.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
