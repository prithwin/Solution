package com.personal;

import com.personal.util.Sorter;

import java.util.*;

/**
 * Created by prajeeva on 7/15/17.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals,new IntervalComparator());

        for(int i = 0 ; i < intervals.size() ; ) {
            if(i > 0) {
                if(intervals.get(i - 1).end >= intervals.get(i).start) {
                    Interval inv = merge(intervals.get(i-1),intervals.get(i));
                    intervals.remove(i);
                    intervals.remove(i-1);
                    intervals.add(i-1,inv);
                    i--;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return intervals;
    }

    private Interval merge(Interval thiz , Interval that) {
        int start = thiz.start < that.start ? thiz.start : that.start;
        int end = thiz.end > that.end ? thiz.end : that.end;
        return new Interval(start,end);
    }
}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval thiz, Interval that) {
        if(thiz.start < that.start) return -1;
        else if(thiz.start > that.start) return 1;
        else return 0;
    }

}

class Interval  implements Comparable{
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }

    @Override
    public int compareTo(Object o) {
        Interval that = (Interval) o;
        if(this.start < that.start) return -1;
        else if(this.start > that.start) return 1;
        else return 0;
    }
}