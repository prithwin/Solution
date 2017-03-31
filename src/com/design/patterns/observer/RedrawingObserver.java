package com.design.patterns.observer;

/**
 * Created by pr250155 on 3/31/17.
 */
public class RedrawingObserver implements CoordinateObserver{
    public void handle(ObservableCordinate c){
        System.out.println("redrawing Co-odinates at: "+c.getX()+","+c.getY());
    }
}
