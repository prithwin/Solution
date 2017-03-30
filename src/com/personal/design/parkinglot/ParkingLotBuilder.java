package com.personal.design.parkinglot;

import java.util.ArrayList;

/**
 * Created by pr250155 on 3/30/17.
 */
public class ParkingLotBuilder {
    ParkingLot lot;
    public ParkingLot build(ParkingType type,int slots){
        if(lot == null){
            this.lot = new ParkingLot();
            lot.slots = new ArrayList<>();
        }
        for(int i = 0 ; i <slots; i++){
            ParkingSlot slot = new ParkingSlot();
            slot.type = type;
            lot.slots.add(slot);
        }
        return lot;
    }
}
