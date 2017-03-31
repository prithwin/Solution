package com.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 3/31/17.
 */
public class ObservableCordinate {
    private int x;
    private int y;
    private boolean changed;
    Lock reenterentLock = new ReentrantLock();
    List<CoordinateObserver> observers;

    public void addObserver(CoordinateObserver observer){
        observers.add(observer);
    }

    private void notifyAllObservers(){
        for(CoordinateObserver observer : observers){
            observer.handle(this);
        }
        reenterentLock.unlock();
    }

    ObservableCordinate(int x,int y){
        this.x = x;
        this.y = y;
        this.changed = false;
        observers = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        reenterentLock.lock();
        this.x = x;
        this.setChanged();
        notifyAllObservers();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        reenterentLock.lock();
        this.y = y;
        this.setChanged();
        notifyAllObservers();
    }

    private void setChanged() {
        this.changed = true;
    }
}
