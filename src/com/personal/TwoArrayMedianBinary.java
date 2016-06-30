package com.personal;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by pr250155 on 1/21/16.
 */
public class TwoArrayMedianBinary {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if(nums1.length == 0){
//            return getMedian(nums2);
//        }
//        if(nums2.length == 0){
//            return getMedian(nums1);
//        }
//        if(nums1.length==1 && nums2.length==1){
//            return ((double)nums1[0] + (double)nums2[0])/2;
//        }
//
//        double nums1Median = getMedian(nums1);
//        double nums2Median = getMedian(nums2);
//        if(nums1Median == nums2Median){
//            return nums1Median;
//        }
//        if(nums1Median < nums2Median){
//            //extract right side of nums1 and left side of nums2
//            return findMedianSortedArrays(Arrays.copyOfRange(nums1,getMedianPosition(nums1), nums1.length),
//                    Arrays.copyOfRange(nums2,0,getMedianPosition(nums2)));
//        } else if(nums1Median > nums2Median){
//            //extract left side of nums1 and right side of nums2
//            return findMedianSortedArrays(Arrays.copyOfRange(nums1,0,getMedianPosition(nums1)),
//                    Arrays.copyOfRange(nums2,getMedianPosition(nums2),nums2.length));
//        }
//        return 0;
//    }
//
//    private int getMedianPosition(int[] array) {
//        if(array.length %2==0){
//            //ever number of items
//            return (array.length/2);
//        } else {
//            //odd number of items
//            return  ((array.length-1)/2);
//        }
//    }
//
//    private double getMedian(int[] array) {
//        double median = 0;
//        if(array.length %2==0){
//            //ever number of items
//            double value1 = array[array.length/2];
//            double value2 = array[(array.length/2)-1];
//            median = (value1 + value2)/2;
//
//        } else {
//            //odd number of items
//            median =  array[(array.length-1)/2];
//        }
//        return median;
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return singleArrayMedian(nums2);
        } else if (nums2.length == 0) {
            return singleArrayMedian(nums1);
        }
        final int k = nums1.length + nums2.length;
        int[] smaller = nums1.length <= nums2.length ? nums1 : nums2;
        int[] bigger = smaller == nums1 ? nums2 : nums1;
        int[] median = findMedian(smaller, bigger, (k - 1) / 2 + 1);
        int m1 = median[0] >= 0 ? smaller[median[0]] : bigger[median[1]];
        if (k % 2 == 1)
            return m1;
        // For even lengths, we need to find the next median.
        // It should be somewhere nearby!
        int i1 = median[0] >= 0 ? median[0] + 1 : -median[0] - 1;
        int i2 = median[1] >= 0 ? median[1] + 1: -median[1] - 1;
        int m2;
        if (i1 == smaller.length) {
            m2 = bigger[i2];
        } else if (i2 == bigger.length) {
            m2 = smaller[i1];
        } else {
            m2 = Math.min(smaller[i1], bigger[i2]);
        }
        return ((double) m1 + m2) / 2.0;
    }

    /**
     * Finds median or one of the medians. The median coordinate is given
     * by the {@code leCount} parameter which can be though of as 1-based
     * index of the median (like in the find kth element problem).
     * The returning value contains two values: first for the {@code nums1}
     * array, second for the {@code nums2} one. One of the values is a
     * non-negative index indicating where the median was found. The other one
     * is an insertion point like in binary search, that is, {@code -index - 1}.
     * Unlike binary search, however, the median may actually be present at
     * that point too, the algorithm just doesn't check that.
     *
     * @param nums1 the first array
     * @param nums2 the second array
     * @param leCount the number of the elements in the merged array that
     * are less than or equal to the median (including itself, but not beyond)
     * @return an array of one index and one insertion point
     */
    private int[] findMedian(int[] nums1, int[] nums2, int leCount) {
        int s1 = 0, e1 = nums1.length - 1;
        while (s1 <= e1) {
            int mid1 = (s1 + e1) / 2;
            // We have exactly mid1 + 1 elements in the first array that
            // are less than or equal to nums1[mid1] (including itself).
            // If mid1 is the median, then there must be exactly
            // leCount - (mid1 + 1) elements in the second array that
            // are less than or equal to the would-be median.
            // All subsequent elements must be greater than or equal,
            // so they can be put into the right half during the merge.
            int le2 = leCount - (mid1 + 1);
            assert le2 >= 0 && le2 <= nums2.length;
            if ((le2 == 0 || nums2[le2 - 1] <= nums1[mid1])
                    && (le2 == nums2.length || nums2[le2] >= nums1[mid1])) {
                return new int[] {mid1, -le2 - 1};
            } else if (le2 > 0 && nums2[le2 - 1] > nums1[mid1]) {
                // missed, the median must be to the right
                s1 = mid1 + 1;
            } else {
                // or to the left
                e1 = mid1 - 1;
            }
        }
        // Haven't found the median in the first array, but we now know
        // where it would be if it was there. That means we know exactly
        // how many elements less than the median are here. That gives
        // us the exact answer where the median is in the second array!
        int mid2 = leCount - s1 - 1;
        assert mid2 >= 0 && mid2 < nums2.length;
        return new int[] {-s1 - 1, mid2};
    }

    private static double singleArrayMedian(int[] nums) {
        if (nums.length % 2 == 0) {
            return ((double) nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return nums[nums.length / 2];
        }
    }

    public static void main (String[] args){
        int[] a ={3};
        int[] b ={1,2};
        System.out.println(new TwoArrayMedianBinary().findMedianSortedArrays(a,b));

    }
}
