package com.personal;

import java.util.Stack;

/**
 * Created by prajeeva on 8/5/17.
 */
public class HistogramWaterTank {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int volume = 0;
        for(int i = 0 ; i < height.length ; i++) {
            while(!st.isEmpty() && height[i] > height[st.peek()]) {
                int mid = st.pop();
                if(st.isEmpty()) break;
                int diff = i - st.peek() - 1;
                int diffDepth = Math.min(height[st.peek()] , height[i]) - height[mid];
                volume += (diff * diffDepth);
            }
            st.push(i);
        }
        return volume;
    }

    public int trapR(int[] height) {
        if(height.length < 3) return 0;
        int st = 0 , en = height.length -1;
        st = nextStart(height, st);
        en = nextEn(height, en);
        int nz = 1 ;
        for(int i : height) {
            if(i != 0) nz++;
        }
        return trapInternal(height, st , en) - nz;
    }

    private int nextEn(int[] height, int en) {
        while(en > 0) {
            if(height[en] > height[en - 1]) break;
            en--;
        }
        return en;
    }

    private int nextStart(int[] height, int st) {
        while(st < height.length - 1) {
            if(height[st + 1] < height[st]) break;
            st++;
        }
        return st;
    }

    private int trapInternal(int[] height , int st , int en) {
        if(en <= st) {
            return 0;
        }
        int diff = en - st - 1;
        if(diff < 1) return 0;
        if((en - st - 1) == 1) {
            int bound = Math.min(height[st] , height[en]) - height[en - 1];
            return bound * diff;
        } else {
            int bound = Math.min(height[st] , height[en]);
            return (bound * diff) + trapInternal(height ,nextStart(height,st + 1), nextEn(height , en -1));
        }
    }
}
