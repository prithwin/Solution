package com.personal.design.parkinglot;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pr250155 on 3/30/17.
 */
public class ParkingLotOrchestratorImpl implements ParkingLotOrchestrator {

    ParkingLot parkingLot = new ParkingLotBuilder().build(ParkingType.CAR, 5);

    @Override
    public void parkVehicle(Vehicle newVehicle) {
        ParkingSlot slot = parkingLot.getFirstFreeParkingSlot(newVehicle);
        if( slot != null) {
            slot.parkVehicle(newVehicle);
        } else {
            //handle case for full parking lot
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
        Car car1 = new Car("KA54MN1522", "Bently cheapster");
        Car car2 = new Car("AN54MN8965", "maruti Regalis");
        CountDownLatch latch = new CountDownLatch(1);
        Thread parker1 = new Thread(new Parker(plo ,car1,latch));
        Thread parker2 = new Thread(new Parker(plo ,car2,latch));
        parker1.start();
        parker2.start();
        latch.countDown();
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
        plo.parkVehicle(car);
    }
}