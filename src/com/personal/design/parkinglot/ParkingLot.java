package com.personal.design.parkinglot;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 3/30/17.
 * this is gonna be a singleton.
 */
public class ParkingLot {
    List<ParkingSlot> slots;
    List<ParkingSlot> empltSlots;
    Lock parkingLotLock = new ReentrantLock();


    ParkingSlot getFirstFreeParkingSlot(Vehicle vehicle){
        try {
            parkingLotLock.lock();
            Iterator<ParkingSlot> iterator = empltSlots.iterator();
            while (iterator.hasNext()) {
                ParkingSlot slot = iterator.next();
                if (slot.mappedVehicle == null && slot.type == vehicle.getType()) {
                    boolean locked = slot.parkingLock.tryLock();
                    if (locked) {
                        iterator.remove();
                        return slot;
                    }
                } else {
                    iterator.remove();
                }
            }
            return null; //means parking lot is full
        }finally {
            parkingLotLock.unlock();
        }
    }

}
