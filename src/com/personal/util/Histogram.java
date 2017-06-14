package com.personal.util;

import java.util.Stack;

/**
 * Created by prith on 14-06-2017.
 */
public class Histogram {
    int[] histogram;

    public Histogram(int[] histogram) {
        this.histogram = histogram;
    }
    public class HistogramData {
        public int area = Integer.MIN_VALUE;
        public int start;
        public int end;
    }
    public HistogramData getMaximumContinuousArea(){
        HistogramData result = new HistogramData();
        StackADT stack = new StackADT(histogram.length);
        for(int i = 0 ; i < histogram.length ; i++) {
            if(stack.isEmpty() ||
                    histogram[stack.peek()] <= histogram[i]) {
                stack.push(i);
            } else {
                int c = 1;
                while(!stack.isEmpty() && histogram[i]<(histogram[stack.peek()])) {
                    int currentArea = c *  histogram[stack.pop()];
                    if(currentArea > result.area) {
                        result.area = currentArea;
                    }
                    c++;
                }
            }
        }
        int c = 1;
        while(!stack.isEmpty()) {
             int currentArea = c * histogram[stack.pop()];
             if(currentArea > result.area) {
                 result.area = currentArea;
             }
             c++;
        }
        return result;
    }
}
