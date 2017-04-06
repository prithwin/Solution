package com.personal.design.parkinglot;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 3/30/17.
 */
public class ParkingSlot {
    ParkingType type;
    Vehicle mappedVehicle;
    Lock parkingLock = new ReentrantLock();
    int slotNumber;

    public boolean parkVehicle(Vehicle newVehicle){
        boolean isLocked = parkingLock.tryLock();
        if(isLocked){
            this.mappedVehicle = newVehicle;
            parkingLock.unlock();
            return true;
        } else {
            parkingLock.unlock();
            return false;

        }
    }
}
