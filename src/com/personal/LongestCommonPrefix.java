package com.personal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/23/17.
 * TODO: not fully functional
 */
public class LongestCommonPrefix {
    public String getLongestCommonPrefix(List<String> aList,List<String> otherList){
        if(aList.size() == 1 && otherList.size()==1){
            return binarySearchLCP(aList.get(0),otherList.get(0));
        } else {
            String leftLCP = getLongestCommonPrefix(aList.subList(0,aList.size()/2),aList.subList(1,(aList.size()/2)+1));
            String rightLCP = getLongestCommonPrefix(otherList.subList(0,otherList.size()/2),otherList.subList(1,(otherList.size()/2)+1));
            return binarySearchLCP(leftLCP,rightLCP);
        }

    }

    private String binarySearchLCP(String thiz, String that) {
        System.out.println("comparing "+thiz+" and "+that);
        int lengthUnderConsideration = thiz.length() < that.length() ? thiz.length() : that.length();
        return realBinarySearchLCP(thiz.substring(0, lengthUnderConsideration), that.substring(0, lengthUnderConsideration), 0, lengthUnderConsideration);
    }

    private String realBinarySearchLCP(String thiz, String that, int start, int end) {
        if(start>end){
            return "";
        }
        if(start==end){
            return thiz.substring(0,start);
        }
        int mid = start + (end - start)/2;
        if(thiz.charAt(mid) == that.charAt(mid) && thiz.charAt(mid-1)!=that.charAt(mid)){
            return thiz.substring(0,mid);
        } else if (thiz.charAt(mid) == that.charAt(mid) && thiz.charAt(mid-1)==that.charAt(mid)){
            return realBinarySearchLCP(thiz,that,mid+1,end);
        } else {
            return realBinarySearchLCP(thiz,that,0,mid-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().getLongestCommonPrefix(Arrays.asList("geeksforgeeks", "geeks"),
                Arrays.asList( "geek", "geezer")));
    }
}
