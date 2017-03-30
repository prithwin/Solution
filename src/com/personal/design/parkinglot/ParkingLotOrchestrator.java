package com.personal.design.parkinglot;

/**
 * Created by pr250155 on 3/30/17.
 */
public interface ParkingLotOrchestrator {
    void parkVehicle(Vehicle newVehicle);
    void enter();
    void leave();
    void generateBill();
}
