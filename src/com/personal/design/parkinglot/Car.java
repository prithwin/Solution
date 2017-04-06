package com.personal.design.parkinglot;

/**
 * Created by pr250155 on 3/30/17.
 */
public class Car extends Vehicle {
    String numberPlate;

    public Car(String nummberPlate, String mode) {
        this.numberPlate = nummberPlate;
        this.model = mode;
    }

    @Override
    public ParkingType getType() {
        return ParkingType.CAR;
    }
}
