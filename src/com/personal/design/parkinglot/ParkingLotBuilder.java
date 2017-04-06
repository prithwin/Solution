package com.personal.design.parkinglot;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by pr250155 on 3/30/17.
 */
public class ParkingLotBuilder {
    ParkingLot lot;
    public ParkingLotBuilder build(ParkingType type,int slots){
        if(lot == null){
            this.lot = new ParkingLot();
            lot.slots = new ArrayList<>();
            lot.empltSlots = new LinkedList<>();
            lot.empltSlots.addAll(lot.slots);
        }
        for(int i = 0 ; i <slots; i++){
            ParkingSlot slot = new ParkingSlot();
            slot.type = type;
            slot.slotNumber = i+1;
            lot.slots.add(slot);
        }
        lot.empltSlots.addAll(lot.slots);
        return this;
    }


    public ParkingLotBuilder addSlots(ParkingType type, int quantity) {
        return build(type,quantity);
    }

    public ParkingLot getInstance() {
        return lot;
    }
}
