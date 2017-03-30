package com.personal.design.parkinglot;

import java.util.List;

/**
 * Created by pr250155 on 3/30/17.
 * this is gonna be a singleton.
 */
public class ParkingLot {
    List<ParkingSlot> slots;


    ParkingSlot getFirstFreeParkingSlot(Vehicle vehicle){
        for(ParkingSlot slot : slots) {
            if(slot.mappedVehicle == null && slot.type == vehicle.getType()){
                boolean locked = slot.parkingLock.tryLock();
                if(locked)
                    return slot;
            }
        }
        return null; //means parking lot is full
    }
}
