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
        for(int i = 0 ; i < histogram.length ;) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
                stack.push(i++);
            } else {
                int toIndex = stack.peek();
                stack.pop();
                int fromIndex = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = histogram[toIndex] * (fromIndex);
                if (area > result.area) {
                    result.area = area;
                    result.start = fromIndex;
                    result.end = toIndex;
                }
            }
        }
        int i = histogram.length;
        if(!stack.isEmpty()) {
            //these are the elements that hung around the respective are they form can be simply compute witht heassumpi
            //tion that I has reached the end and there is no breakage from this element to the end, and yes this if con
            //dition is written here just to show that this details exist in the code and is a special condition that yo
            //u woudl have to handle spearately.
            while(!stack.isEmpty()) {
                int toIndex = stack.peek();
                stack.pop();
                int fromIndex = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = histogram[toIndex] * (fromIndex);
                if (area > result.area) {
                    result.area = area;
                    result.start = fromIndex;
                    result.end = toIndex;
                }
            }
        }
        return result;
    }
}
