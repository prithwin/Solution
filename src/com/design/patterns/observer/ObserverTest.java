package com.design.patterns.observer;

/**
 * Created by pr250155 on 3/31/17.
 */
public class ObserverTest {
    public static void main(String[] args) {
        ObservableCordinate cordinate = new ObservableCordinate(1,2);
        cordinate.addObserver(new RedrawingObserver());
        cordinate.addObserver(new SquareCheckObserver());
        cordinate.setX(4);
        cordinate.setX(7);
        cordinate.setY(8);
        cordinate.setY(9);

    }
}
