package com.personal.design.elevator;

/**
 * Created by prajeeva on 7/21/17.
 */
public class ElevatorDoor {
    boolean isOpen = false;
    public void openDoor() {
        System.out.println("Door opening");
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        isOpen = true;
    }

    public void closeDoor() {
        System.out.println("door closing");
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        isOpen = false;
    }


    public boolean isOpen() {
        return isOpen;
    }
}
