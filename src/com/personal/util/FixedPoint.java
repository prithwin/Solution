package com.personal.util;

/**
 * Created by pr250155 on 5/23/17.
 */
public class FixedPoint {
    public int x;
    public int y;

    public FixedPoint(int i, int j) {
        if(j<=8) {
            this.x = i;
            this.y = j;
        } else {
            this.x = i+1;
            this.y = 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        FixedPoint that = (FixedPoint) obj;
        if(this.x == that.x && this.y == that.y) return true;
        return false;
    }
}
