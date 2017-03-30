package com.personal.design.parkinglot;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pr250155 on 3/30/17.
 */
public class ParkingLotOrchestratorImpl implements ParkingLotOrchestrator {

    ParkingLot parkingLot = new ParkingLotBuilder().build(ParkingType.CAR, 5).
            addSlots(ParkingType.BIKE, 10).
            addSlots(ParkingType.SUV, 5).
            getInstance();

    @Override
    public boolean parkVehicle(Vehicle newVehicle) {
        ParkingSlot slot = parkingLot.getFirstFreeParkingSlot(newVehicle);
        if( slot != null) {
            return slot.parkVehicle(newVehicle);
        } else {
           return false;
        }
    }

    @Override
    public void enter() {

    }

    @Override
    public void leave() {

    }

    @Override
    public void generateBill() {

    }

    public static void main(String[] args) {
        ParkingLotOrchestrator plo = new ParkingLotOrchestratorImpl();
        CountDownLatch latch = new CountDownLatch(1);
        Thread parker1 = new Thread(new Parker(plo ,new Car("KA54MN1522", "Bently cheapster"),latch));
        Thread parker2 = new Thread(new Parker(plo ,new Car("AN54MN8965", "maruti Regalis"),latch));
        Thread parker3 = new Thread(new Parker(plo ,new Car("KA54MN1545", "vwoksfaggen doos"),latch));
        Thread parker4 = new Thread(new Parker(plo ,new Car("KA54MN1000", "toyota junktis"),latch));
        Thread parker5 = new Thread(new Parker(plo ,new Car("KA54MN1001", "volvo thangs"),latch));
        Thread parker6 = new Thread(new Parker(plo ,new Car("KA54MN1002", "tata nothingus"),latch));
        parker1.start();
        parker2.start();
        parker3.start();
        parker4.start();
        parker5.start();
        parker6.start();
        latch.countDown(); //Go
        System.out.println("wait");
    }
}


class Parker implements Runnable{

    ParkingLotOrchestrator plo;
    Car car;
    CountDownLatch latch;

    Parker(ParkingLotOrchestrator plo, Car car, CountDownLatch latch){
        this.plo= plo;
        this.car = car;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(car.model+" has been parked : "+plo.parkVehicle(car));
    }
}