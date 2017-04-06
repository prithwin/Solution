package com.personal.design.parkinglot;

/**
 * Created by pr250155 on 3/30/17.
 */
public interface ParkingLotOrchestrator {
    boolean parkVehicle(Vehicle newVehicle);
    void enter();
    void leave(int slot);
    void generateBill();
}
