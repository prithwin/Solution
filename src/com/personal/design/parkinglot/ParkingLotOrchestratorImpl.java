package com.personal.design.parkinglot;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pr250155 on 3/30/17.
 */
public class ParkingLotOrchestratorImpl implements ParkingLotOrchestrator {

    ParkingLot parkingLot = new ParkingLotBuilder().build(ParkingType.CAR, 5).
//            addSlots(ParkingType.BIKE, 10).
//            addSlots(ParkingType.SUV, 5).
            getInstance();

    @Override
    public boolean parkVehicle(Vehicle newVehicle) {

        ParkingSlot slot = parkingLot.getFirstFreeParkingSlot(newVehicle);
        if( slot != null) {
            System.out.println(newVehicle.model+" ===============>: "+ slot.slotNumber);
            try{return slot.parkVehicle(newVehicle);}
            finally {
                slot.parkingLock.unlock();
            }
        } else {
            System.out.println(newVehicle.model+" could not be parked waiting and retrying" );
           return false;
        }
    }

    @Override
    public void enter() {

    }

    @Override
    public void leave(int slotNumber) {

        ParkingSlot slot = parkingLot.slots.get(slotNumber-1);
        try {
            slot.parkingLock.lock();
            slot.mappedVehicle = null;
            if (parkingLot.empltSlots.size() == 0) {
                this.parkingLot.empltSlots.add(0, slot);
                return;
            }
            ParkingSlot nearest = parkingLot.empltSlots.get(0);
            if (nearest == null || slot.slotNumber < nearest.slotNumber) {
                this.parkingLot.empltSlots.add(0, slot);
                return;
            }
            int i = 0;
            while (i < parkingLot.empltSlots.size() - 1 && parkingLot.empltSlots.get(i).slotNumber <= slot.slotNumber) {
                if(parkingLot.empltSlots.get(i).slotNumber == slot.slotNumber) {
                    return;
                }
                i++;
            }
            this.parkingLot.empltSlots.add(i + 1, slot);
//            slot.parkingLock.unlock();
        }finally {
            slot.parkingLock.unlock();
        }
    }

    @Override
    public void generateBill() {

    }

    public static void main(String[] args) {
        ParkingLotOrchestrator plo = new ParkingLotOrchestratorImpl();
        CountDownLatch latch = new CountDownLatch(1);
        //plo.leave(4);
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
        latch.countDown();
        while(parker1.isAlive() &&
                parker2.isAlive() &&
                parker3.isAlive() &&
                parker4.isAlive() &&
                parker5.isAlive() &&
                parker6.isAlive()
                ){}
        plo.leave(4);
        plo.leave(2);
//        plo.leave(5);
//        plo.leave(3);
        plo.leave(1);
        CountDownLatch latch1 = new CountDownLatch(1);
        Thread parker7 = new Thread(new Parker(plo ,new Car("KA54MN14534", "new Slot 2"),latch1));
        parker7.start();
        latch1.countDown();
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
        boolean isparked = plo.parkVehicle(car);
        if(!isparked) {
            for (int i = 0; i < 10 && !isparked; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isparked =  plo.parkVehicle(car);
            }
        }
    }
}