package com.design.patterns.observer;

/**
 * Created by pr250155 on 3/31/17.
 */
public class SquareCheckObserver implements CoordinateObserver {
    @Override
    public void handle(ObservableCordinate cordinate) {
        System.out.println("checking to see if the bullet connected ");
    }
}
